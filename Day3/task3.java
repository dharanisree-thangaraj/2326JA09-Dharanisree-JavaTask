public class OverloadExample {
    static int sum(int a, int b) {
        return a + b;
    }
    static double sum(double a, double b) {
        return a + b;
    }
    public static void main(String[] args) {
        int intResult = sum(10, 20);
        double doubleResult = sum(5.5, 4.5);
        System.out.println("Sum of integers: " + intResult);
        System.out.println("Sum of doubles: " + doubleResult);
    }
}
