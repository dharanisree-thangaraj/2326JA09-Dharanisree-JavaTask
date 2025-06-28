class TicketBookingSystem {
    private int totalSeats = 5;  
    public synchronized void bookTicket(String user, int seatsRequested) {
        System.out.println(user + " is trying to book " + seatsRequested + " seat(s)...");

        // Simulate delay
        try {
            Thread.sleep(1000);  
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        if (seatsRequested <= totalSeats) {
            System.out.println("Booking successful for " + user + "!");
            totalSeats -= seatsRequested;
        } else {
            System.out.println("Booking failed for " + user + ". Not enough seats.");
        }

        System.out.println("Remaining seats: " + totalSeats + "\n");
    }
}
class User extends Thread {
    private TicketBookingSystem bookingSystem;
    private String userName;
    private int seatsToBook;
    User(TicketBookingSystem system, String name, int seats) {
        this.bookingSystem = system;
        this.userName = name;
        this.seatsToBook = seats;
    }
    public void run() {
        bookingSystem.bookTicket(userName, seatsToBook);
    }
}
public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem;
        User u1 = new User(bookingSystem, "Alice", 2);
        User u2 = new User(bookingSystem, "Bob", 2);
        User u3 = new User(bookingSystem, "Charlie", 2);
        u1.start();
        u2.start();
        u3.start();
    }
}
