
class Person {
    String name;
    int age;
    Person(String n, int a) {
        name = n;
        age = a;
    }
}
class Employee extends Person {
    double basicSalary;
    Employee(String n, int a, double salary) {
        super(n, a);
        basicSalary = salary;
    }
    double calculateSalary() {
        double hra = 0.2 * basicSalary; 
        double da = 0.1 * basicSalary;  
        return basicSalary + hra + da;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Total Salary: " + calculateSalary());
    }
}
public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("John", 30, 50000);
        emp.display();
    }
}
