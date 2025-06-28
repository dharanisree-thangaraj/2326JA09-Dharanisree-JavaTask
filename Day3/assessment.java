import java.util.ArrayList;
class Library {
    ArrayList<String> books = new ArrayList<>();
    void addBook(String book) {
        books.add(book);
        System.out.println(book + " added to the library.");
    }
    void removeBook(String book) {
        if (books.remove(book))
            System.out.println(book + " removed from the library.");
        else
            System.out.println(book + " not found.");
    }

    void issueBook(String book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println(book + " issued.");
        } else {
            System.out.println(book + " not available.");
        }
    }
    void showBooks() {
        System.out.println("Books in library: " + books);
    }
}
public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Java Basics");
        lib.addBook("Python Guide");
        lib.addBook("C++ Fundamentals");
        lib.showBooks();
        lib.issueBook("Java Basics");
        lib.removeBook("Python Guide");
        lib.showBooks();
    }
}
