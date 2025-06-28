import java.io.*;
public class ResultProcessor {
    public static void main(String[] args) {
        String inputFile = "marks.txt";
        String outputFile = "result.txt";
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    writer.write("Invalid data: " + line);
                    writer.newLine();
                    continue;
                }
                String name = parts[0].trim();
                int mark1 = Integer.parseInt(parts[1].trim());
                int mark2 = Integer.parseInt(parts[2].trim());
                int mark3 = Integer.parseInt(parts[3].trim());
                int total = mark1 + mark2 + mark3;
                double average = total / 3.0;
                String result = (mark1 >= 35 && mark2 >= 35 && mark3 >= 35) ? "Pass" : "Fail";
                writer.write(name + " - Total: " + total + ", Average: " + String.format("%.2f", average) + ", Result: " + result);
                writer.newLine();
            }
            System.out.println("Results written to " + outputFile);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
