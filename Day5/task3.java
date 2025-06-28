import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class StudentMarksAverage {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMarks = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Enter student names and marks (type 'exit' to stop) ---");
        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Enter marks: ");
            int marks;
            try {
                marks = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
                continue;
            }
            studentMarks.put(name, marks);
        }
        System.out.println("\n--- Student Marks ---");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        if (!studentMarks.isEmpty()) {
            int total = 0;
            for (int mark : studentMarks.values()) {
                total += mark;
            }
            double average = (double) total / studentMarks.size();
            System.out.println("\nAverage Marks: " + String.format("%.2f", average));
        } else {
            System.out.println("\nNo marks entered.");
        }
    }
}
