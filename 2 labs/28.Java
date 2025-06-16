import java.util.Scanner;

class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Шифр Цезаря");
            System.out.println("-----------");
            
            System.out.print("Введите строку для шифрования: ");
            String input = scanner.nextLine();
            
            System.out.print("Введите число сдвига: ");
            int shift = scanner.nextInt();
            
            System.out.print("Введите направление (1 - вправо, -1 - влево): ");
            int direction = scanner.nextInt();
            
            String result = caesarCipher(input, shift, direction);
            
            System.out.println("\nРезультат: " + result);
        } finally {
            scanner.close(); 
        }
    }
    
    public static String caesarCipher(String input, int shift, int direction) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int originalPosition = c - base;
                int newPosition = (originalPosition + direction * shift) % 26;
                
                if (newPosition < 0) {
                    newPosition += 26;
                }
                
                c = (char)(base + newPosition);
            }
            
            result.append(c);
        }
        
        return result.toString();
    }
}
