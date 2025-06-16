import java.util.Scanner;
import java.util.Random;

class CodeBreakerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int[] secretCode = new int[4];
        for (int i = 0; i < 4; i++) {
            secretCode[i] = random.nextInt(10); 
        }
        
        System.out.println("Компьютер загадал 4-значный код. Попробуйте угадать его за меньше чем 20 попыток!");
        System.out.println("После каждой попытки вы узнаете количество угаданных цифр (но не их позиции).");
        
        int attempts = 0;
        boolean guessed = false;
        
        while (attempts < 20 && !guessed) {
            System.out.println("\nПопытка #" + (attempts + 1));
            System.out.println("Введите 4 цифры через пробел (от 0 до 9):");
            
            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = scanner.nextInt();
            }
            
            int matches = countMatches(secretCode, guess);
            System.out.println("Совпадений: " + matches);
            
            if (matches == 4) {
                guessed = true;
                System.out.println("Поздравляем! Вы угадали код за " + (attempts + 1) + " попыток!");
            }
            
            attempts++;
        }
        
        if (!guessed) {
            System.out.println("\nК сожалению, вы не угадали код за 20 попыток.");
            System.out.print("Загаданный код был: ");
            for (int num : secretCode) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    private static int countMatches(int[] secret, int[] guess) {
        int[] secretCopy = secret.clone();
        int[] guessCopy = guess.clone();
        int matches = 0;
        
        for (int i = 0; i < secretCopy.length; i++) {
            for (int j = 0; j < guessCopy.length; j++) {
                if (secretCopy[i] == guessCopy[j] && secretCopy[i] != -1) {
                    matches++;
                    secretCopy[i] = -1; 
                    guessCopy[j] = -1;   
                    break;
                }
            }
        }
        
        return matches;
    }
}
