import java.util.HashSet;
import java.util.Scanner;
public class UniqueEmails {
    public static void main(String[] args) {
        HashSet<String> emailSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Enter email addresses (type 'exit' to finish) ---");
        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.nextLine().trim();
            if (email.equalsIgnoreCase("exit")) {
                break;
            }
            if (emailSet.add(email)) {
                System.out.println("Email added.");
            } else {
                System.out.println("Duplicate email! Not added.");
            }
        }
        System.out.println("\n--- Unique Email Addresses ---");
        for (String email : emailSet) {
            System.out.println(email);
        }
    }
}
