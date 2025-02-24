import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            System.out.println("\nContents of the file:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine() + "\n");

            }

            scanner.close(); // Close the scanner
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please check the file path.\n");
        }
    }
}