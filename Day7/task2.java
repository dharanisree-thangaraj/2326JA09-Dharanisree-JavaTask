import java.sql.*;
import java.util.Scanner;
public class InsertStudentJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        System.out.print("Enter student grade: ");
        String grade = sc.next();    
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, grade);
                int rowsInserted = stmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        sc.close();
    }
}
