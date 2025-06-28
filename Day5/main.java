import java.util.*;
public class SimpleEnrollment {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        HashMap<String, List<String>> coursesMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Student\n2. Enroll Course\n3. Display\n4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    if (!students.contains(name)) {
                        students.add(name);
                        coursesMap.put(name, new ArrayList<>());
                        System.out.println("Student added.");
                    } else {
                        System.out.println("Student already exists.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    if (coursesMap.containsKey(name)) {
                        System.out.print("Enter course: ");
                        String course = sc.nextLine();
                        coursesMap.get(name).add(course);
                        System.out.println("Course enrolled.");
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 3 -> {
                    Iterator<String> it = students.iterator();
                    while (it.hasNext()) {
                        String name = it.next();
                        System.out.println("Student: " + name);
                        List<String> courseList = coursesMap.get(name);
                        if (courseList.isEmpty()) {
                            System.out.println("  No courses enrolled.");
                        } else {
                            for (String c : courseList) {
                                System.out.println("  - " + c);
                            }
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
