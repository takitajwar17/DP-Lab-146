package algorithms;

public interface EncryptionAlgorithm {
    String encrypt(String plaintext, String key) throws Exception;
    String decrypt(String ciphertext, String key) throws Exception;
}
