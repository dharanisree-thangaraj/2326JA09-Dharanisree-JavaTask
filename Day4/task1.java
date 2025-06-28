public class SafeDivide {
    public static void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
    public static void main(String[] args) {
        divide(10, 2); 
        divide(5, 0);   
    }
}
