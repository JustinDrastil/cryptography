import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args[0].equals("encrypt")){
            System.out.println("Enter the message: ");
            String message = scanner.nextLine();
            
            System.out.println("Enter the keyword: ");
            int key = scanner.nextInt();
            
            String encryptedMessage = encrypt(message, key);
            System.out.println("Encrypted Message: " + encryptedMessage);
        }
        
        if(args[0].equals("decrypt")){
            System.out.println("Enter the encrypted message: ");
            String encryptedMessage = scanner.nextLine();
            
            System.out.println("Enter the keyword: ");
            int key = scanner.nextInt();
            
            String decryptedMessage = decrypt(encryptedMessage, key);
            System.out.println("Decrypted Message: " + decryptedMessage);
        }
        
        scanner.close();
    }
    
    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();
        
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int shiftedPosition = (character - base + key) % 26;
                encrypted.append((char) (base + shiftedPosition));
            } else {
                encrypted.append(character);
            }
        }
        
        return encrypted.toString();
    }
    
    public static String decrypt(String message, int key) {
        StringBuilder decrypted = new StringBuilder();
        
        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int shiftedPosition = (character - base - key + 26) % 26;
                decrypted.append((char) (base + shiftedPosition));
            } else {
                decrypted.append(character);
            }
        }
        
        return decrypted.toString();
    }
}
