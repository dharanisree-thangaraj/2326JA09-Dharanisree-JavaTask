class MessagePrinter implements Runnable {
    String message;
    MessagePrinter(String message) {
        this.message = message;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}
public class Main {
    public static void main(String[] args){
        Runnable task1 = new MessagePrinter("Hello from Thread 1");
        Runnable task2 = new MessagePrinter("Greetings from Thread 2");
        Runnable task3 = new MessagePrinter("Message from Thread 3");
        Thread t1 = new Thread(task1, "T1");
        Thread t2 = new Thread(task2, "T2");
        Thread t3 = new Thread(task3, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
