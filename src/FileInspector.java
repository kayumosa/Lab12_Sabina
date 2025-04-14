import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src"));

        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try {
                Scanner in = new Scanner(selectedFile);
                System.out.println("File content:");

                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                    lineCount++;

                    String[] words = line.trim().split("\\s+");
                    if (!line.trim().isEmpty()) {
                        wordCount += words.length;
                    }

                    charCount += line.length();
                }
                in.close();

                // Summary report
                System.out.println("\n--- File Summary ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Lines: " + lineCount);
                System.out.println("Words: " + wordCount);
                System.out.println("Characters: " + charCount);

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }
}

