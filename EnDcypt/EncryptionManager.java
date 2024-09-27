import algorithms.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EncryptionManager {
    private EncryptionAlgorithm algorithm;
    public void selectAlgorithm(String choice, int shift) throws Exception {
        switch (choice.toUpperCase()) {
            case "AES":
                algorithm = new AES();
                break;
            case "DES":
                algorithm = new DES();
                break;
            case "CAESAR":
                algorithm = new CaesarCipher(shift);
                break;
            default:
                throw new Exception("Invalid encryption method or missing parameters.");
        }
    }
    public String[] processFile(String filename) throws IOException, Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String data;
            StringBuilder allData = new StringBuilder();
            while ((data = reader.readLine()) != null) {
                allData.append(data).append("\n");
            }
            String plaintext = allData.toString().trim();
            String key = getKey();
            String encryptedData = algorithm.encrypt(plaintext, key);
            String decryptedData = algorithm.decrypt(encryptedData, key);
            return new String[]{encryptedData, decryptedData};
        }
    }


    private String getKey() {
        return "defaultSecretKey";
    }
}
