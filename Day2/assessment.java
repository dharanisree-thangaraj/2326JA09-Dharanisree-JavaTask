public class MiniAddressBook {
    public static void main(String[] args) {
        String[] names = { "Alice", "Bob", "Charlie", "Diana", "Eve" };
        String[] phones = { "123-456-7890", "987-654-3210", "555-123-4567", "444-555-6666", "999-888-7777" };
        System.out.println("Mini Address Book:");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". Name: " + names[i] + ", Phone: " + phones[i]);
        }
    }
}
