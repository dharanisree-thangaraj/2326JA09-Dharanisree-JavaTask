import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteFileExample {
    public static void main(String[] args) {
        String filePath = "output.txt"; 
        String[] lines = {
            "Hello, world!",
            "This is a test.",
            "Writing to a file line by line in Java."
        };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); 
            }
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
