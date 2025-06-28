import java.io.*;
import java.util.*;
public class EmployeeCRUD {
    static final String FILE_NAME = "employees.txt";
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Employee Record System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> viewEmployees();
                case 3 -> updateEmployee(sc);
                case 4 -> deleteEmployee(sc);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
    static void addEmployee(Scanner sc) throws IOException {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();
        System.out.print("Enter Salary: ");
        String salary = sc.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(id + "," + name + "," + designation + "," + salary);
            bw.newLine();
            System.out.println("Employee added successfully!");
        }
    }
    static void viewEmployees() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No records found.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nID\tName\tDesignation\tSalary");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4)
                    System.out.printf("%s\t%s\t%s\t%s\n", parts[0], parts[1], parts[2], parts[3]);
            }
        }
    }
    static void updateEmployee(Scanner sc) throws IOException {
        System.out.print("Enter Employee ID to update: ");
        String idToUpdate = sc.nextLine();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");
        boolean updated = false;
        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(idToDelete)) {
                    bw.write(line);
                    bw.newLine();
                } else {
                    deleted = true;
                }
            }
        }
        if (deleted) {
            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println("Employee deleted successfully.");
        } else {
            tempFile.delete();
            System.out.println("Employee ID not found.");
        }
    }
}
