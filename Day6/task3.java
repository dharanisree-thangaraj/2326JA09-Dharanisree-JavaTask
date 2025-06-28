class Worker extends Thread {
    private String taskName;

    Worker(String name) {
        this.taskName = name;
    }

    public void run() {
        try {
            System.out.println(taskName + " started.");
            Thread.sleep(1000); // Sleep for 1 second
            System.out.println(taskName + " finished.");
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted.");
        }
    }
}

public class ThreadCoordination {
    public static void main(String[] args) {
        Worker t1 = new Worker("Task 1");
        Worker t2 = new Worker("Task 2");
        t1.start();
        try {
            t1.join();
            System.out.println("Main thread waited for Task 1.");
        } catch (InterruptedException e) {
            System.out.println("Main interrupted while waiting.");
        }
        t2.start(); 
        try {
            t2.join(); 
        } catch (InterruptedException e) {
            System.out.println("Main interrupted while waiting for Task 2.");
        }
        System.out.println("Main thread completed.");
    }
}
