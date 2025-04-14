import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;
        String more;

        do {
            System.out.print("First Name: ");
            String firstName = in.nextLine();

            System.out.print("Last Name: ");
            String lastName = in.nextLine();

            String id = String.format("%06d", idCounter); // 000001 style

            System.out.print("Email: ");
            String email = in.nextLine();

            System.out.print("Year of Birth (YYYY): ");
            String year = in.nextLine();

            // CSV format
            String record = firstName + ", " + lastName + ", " + id + ", " + email + ", " + year;
            records.add(record); // 👈 INSERT command for ArrayList

            idCounter++;

            System.out.print("Do you want to enter another record? (yes/no): ");
            more = in.nextLine();
        } while (more.equalsIgnoreCase("yes"));

        // Ask for file name
        System.out.print("Enter the file name to save (with .csv): ");
        String fileName = in.nextLine();

        try {
            FileWriter writer = new FileWriter("src/" + fileName);
            for (String r : records) {
                writer.write(r + "\n");
            }
            writer.close();
            System.out.println("Data saved successfully to src/" + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}

