import java.util.Scanner;

class CaesarCipherDecoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите зашифрованный текст:");
        String encryptedText = scanner.nextLine();
        
        System.out.println("Введите ключ сдвига (целое число):");
        int shift = scanner.nextInt();
        
        String decryptedText = decryptCaesarCipher(encryptedText, shift);
        System.out.println("Расшифрованный текст:");
        System.out.println(decryptedText);
        scanner.close();
    }
    
    public static String decryptCaesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char)(((c - base - shift + 26) % 26) + base);
            }
            
            result.append(c);
        }
        
        return result.toString();
    }
}
