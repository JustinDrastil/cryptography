import java.util.Scanner;

public class VigenereCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the message: ");
        String message = scanner.nextLine();
        
        System.out.println("Enter the keyword: ");
        String keyword = scanner.nextLine();
        
        String encryptedMessage = encrypt(message, keyword);
        System.out.println("Encrypted Message: " + encryptedMessage);
        
        String decryptedMessage = decrypt(encryptedMessage, keyword);
        System.out.println("Decrypted Message: " + decryptedMessage);
        
        scanner.close();
    }
    
    public static String encrypt(String message, String keyword) {
        StringBuilder encrypted = new StringBuilder();
        keyword = keyword.toLowerCase();
        
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int keywordIndex = i % keyword.length();
                int shift = keyword.charAt(keywordIndex) - 'a';
                int shiftedPosition = (character - base + shift) % 26;
                encrypted.append((char) (base + shiftedPosition));
            } else {
                encrypted.append(character);
            }
        }
        
        return encrypted.toString();
    }
    
    public static String decrypt(String message, String keyword) {
        StringBuilder decrypted = new StringBuilder();
        keyword = keyword.toLowerCase();
        
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int keywordIndex = i % keyword.length();
                int shift = keyword.charAt(keywordIndex) - 'a';
                int shiftedPosition = (character - base - shift + 26) % 26;
                decrypted.append((char) (base + shiftedPosition));
            } else {
                decrypted.append(character);
            }
        }
        
        return decrypted.toString();
    }
}
