import java.util.*;
import java.io.*;

public class StudentManagementApp {
    static ArrayList<String> students = new ArrayList<>();
    static HashMap<String, List<String>> coursesMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static final String OUTPUT_FILE = "students_courses.txt";

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Add Student  2.Search Student  3.Delete Student");
            System.out.println("4.Enroll Course  5.Save & Exit");
            System.out.print("Choice: ");
            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> searchStudent();
                case 3 -> deleteStudent();
                case 4 -> enrollCourse();
                case 5 -> { saveToFile(); System.out.println("Saved. Bye!"); }
                default -> System.out.println("Invalid choice.");
            }
        } while (ch != 5);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (students.contains(name)) {
            System.out.println("Already exists!");
            return;
        }
        students.add(name);
        coursesMap.put(name, new ArrayList<>());
        System.out.println("Added.");
    }

    static void searchStudent() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        if (students.contains(name)) {
            System.out.println("Found: " + name);
            System.out.println("Courses: " + coursesMap.get(name));
        } else System.out.println("Not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();
        if (students.remove(name)) {
            coursesMap.remove(name);
            System.out.println("Deleted.");
        } else System.out.println("Not found.");
    }

    static void enrollCourse() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        if (!students.contains(name)) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course to enroll: ");
        String course = sc.nextLine();
        List<String> list = coursesMap.get(name);
        if (list.contains(course)) {
            System.out.println("Already enrolled.");
        } else {
            list.add(course);
            System.out.println("Enrolled in " + course);
        }
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (String s : students) {
                bw.write(s + " -> " + coursesMap.get(s));
                bw.newLine();
            }
        } catch (IOException e) {
          import java.util.*;
import java.io.*;

public class StudentManagementApp {
    static ArrayList<String> students = new ArrayList<>();
    static HashMap<String, List<String>> coursesMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static final String OUTPUT_FILE = "students_courses.txt";

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("\n1.Add Student  2.Search Student  3.Delete Student");
            System.out.println("4.Enroll Course  5.Save & Exit");
            System.out.print("Choice: ");
            ch = Integer.parseInt(sc.nextLine());
            switch (ch) {
                case 1 -> addStudent();
                case 2 -> searchStudent();
                case 3 -> deleteStudent();
                case 4 -> enrollCourse();
                case 5 -> { saveToFile(); System.out.println("Saved. Bye!"); }
                default -> System.out.println("Invalid choice.");
            }
        } while (ch != 5);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (students.contains(name)) {
            System.out.println("Already exists!");
            return;
        }
        students.add(name);
        coursesMap.put(name, new ArrayList<>());
        System.out.println("Added.");
    }

    static void searchStudent() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        if (students.contains(name)) {
            System.out.println("Found: " + name);
            System.out.println("Courses: " + coursesMap.get(name));
        } else System.out.println("Not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();
        if (students.remove(name)) {
            coursesMap.remove(name);
            System.out.println("Deleted.");
        } else System.out.println("Not found.");
    }

    static void enrollCourse() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        if (!students.contains(name)) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course to enroll: ");
        String course = sc.nextLine();
        List<String> list = coursesMap.get(name);
        if (list.contains(course)) {
            System.out.println("Already enrolled.");
        } else {
            list.add(course);
            System.out.println("Enrolled in " + course);
        }
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            for (String s : students) {
                bw.write(s + " -> " + coursesMap.get(s));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

            System.out.println("File error: " + e.getMessage());
        }
    }
}
