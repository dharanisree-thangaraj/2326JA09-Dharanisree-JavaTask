MYSQL CODE:
  CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    grade VARCHAR(10)
);

JAVA CODE:
  import java.sql.*;
import java.util.Scanner;

public class StudentDBManager {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "your_username";
    static final String PASSWORD = "your_password";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            return;
        }

        while (true) {
            System.out.println("\n--- Student Database Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " student(s) added.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
    static void viewStudents() {
        String sql = "SELECT * FROM students";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nID\tName\tAge\tGrade");
            System.out.println("----------------------------------");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%d\t%s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("grade"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }
    static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("New name: ");
        String name = sc.nextLine();
        System.out.print("New age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("New grade: ");
        String grade = sc.nextLine();
        String sql = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " student(s) updated.");
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " student(s) deleted.");
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
