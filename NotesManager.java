import java.io.*;
import java.util.Scanner;

public class NotesManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n=== Notes Manager ===");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        FileWriter writer = new FileWriter(fileName, true);
                        System.out.print("Enter your note: ");
                        String note = sc.nextLine();

                        writer.write(note + "\n");
                        writer.close();

                        System.out.println("Note saved successfully!");
                    } catch (IOException e) {
                        System.out.println("Error writing to file.");
                    }
                    break;

                case 2:
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;

                        System.out.println("\n--- Your Notes ---");
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("No notes found.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting Notes Manager...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}