package algorithms;

public class CaesarCipher implements EncryptionAlgorithm {
    private int shift;

    public CaesarCipher(int shift) {
        // Normalize the shift to be within 0-25
        this.shift = shift % 26;
        if (this.shift < 0) {
            this.shift += 26;
        }
    }

    @Override
    public String encrypt(String plaintext, String key) {
        return shift(plaintext, shift);
    }

    @Override
    public String decrypt(String ciphertext, String key) {
        return shift(ciphertext, 26 - shift);
    }

    private String shift(String input, int shiftAmount) {
        StringBuilder result = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (Character.isUpperCase(character)) {
                char shifted = (char) (((character - 'A' + shiftAmount) % 26) + 'A');
                result.append(shifted);
            } else if (Character.isLowerCase(character)) {
                char shifted = (char) (((character - 'a' + shiftAmount) % 26) + 'a');
                result.append(shifted);
            } else {
                // Non-alphabetic characters are not shifted
                result.append(character);
            }
        }
        return result.toString();
    }
}
