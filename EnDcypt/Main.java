import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EncryptionManager manager = new EncryptionManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select encryption algorithm (AES, DES, Caesar): ");
        String choice = scanner.nextLine();

        int shift = 0;
        if ("Caesar".equalsIgnoreCase(choice)) {
            System.out.println("Enter shift value (integer): ");
            while (true) {
                try {
                    shift = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer for shift value:");
                }
            }
        }

        try {
            manager.selectAlgorithm(choice, shift);
            System.out.println("Enter filename to encrypt: ");
            String filename = scanner.nextLine();

            File file = new File(filename);
            if (!file.exists() || !file.isFile()) {
                System.out.println("File does not exist or is not a regular file.");
                return;
            }

            String[] results = manager.processFile(filename);
            System.out.println("Encrypted Data:\n" + results[0]);
            System.out.println("Decrypted Data:\n" + results[1]);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
