package algorithms;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DES implements EncryptionAlgorithm {
    private static final String ALGORITHM = "DES";

    @Override
    public String encrypt(String plaintext, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKey = getSecretKey(key);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @Override
    public String decrypt(String ciphertext, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKey = getSecretKey(key);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, "UTF-8");
    }

    private SecretKeySpec getSecretKey(String key) throws Exception {
        byte[] keyBytes = key.getBytes("UTF-8");
        if (keyBytes.length != 8) {
            throw new Exception("Invalid DES key length (must be 8 bytes)");
        }
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }
}
