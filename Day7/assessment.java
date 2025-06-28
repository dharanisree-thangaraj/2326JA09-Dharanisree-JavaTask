SQL CODE:
CREATE DATABASE IF NOT EXISTS inventorydb;
USE inventorydb;

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL
);


JAVA CODE:
  import java.sql.*;
import java.util.Scanner;

public class InventoryApp {

    static final String URL = "jdbc:mysql://localhost:3306/inventorydb";
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
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> searchProduct();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());

        String sql = "INSERT INTO products (product_name, quantity, price) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);

            int rows = stmt.executeUpdate();
            System.out.println(rows + " product(s) added.");

        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    static void viewProducts() {
        String sql = "SELECT * FROM products";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nID\tName\t\tQuantity\tPrice");
            System.out.println("--------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%d\t%s\t\t%d\t\t%.2f%n",
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving products: " + e.getMessage());
        }
    }

    static void searchProduct() {
        System.out.print("Enter product name to search: ");
        String searchName = sc.nextLine();

        String sql = "SELECT * FROM products WHERE product_name LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + searchName + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                boolean found = false;
                System.out.println("\nSearch Results:");
                System.out.println("ID\tName\t\tQuantity\tPrice");
                System.out.println("--------------------------------------------------");

                while (rs.next()) {
                    found = true;
                    System.out.printf("%d\t%s\t\t%d\t\t%.2f%n",
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getInt("quantity"),
                            rs.getDouble("price"));
                }
                if (!found) {
                    System.out.println("No matching products found.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error searching products: " + e.getMessage());
        }
    }
}
