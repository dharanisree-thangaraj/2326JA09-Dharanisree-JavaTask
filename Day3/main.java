class Student {
    String name;
    int rollNo;
    int[] marks = new int[3];
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    void assignMarks(int m1, int m2, int m3) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }
    int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }
    String getGrade() {
        int avg = getTotal() / 3;
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }
    void displayResult() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.println("Total: " + getTotal());
        System.out.println("Grade: " + getGrade());
    }
}
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101);
        s1.assignMarks(85, 78, 92);
        s1.displayResult();
    }
}
