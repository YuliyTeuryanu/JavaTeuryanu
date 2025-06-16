import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Set;

class RemoveDuplicateWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите строку с повторяющимися словами:");
        String input = scanner.nextLine();
        
        String[] words = input.split(" ");
        
        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        
        StringBuilder result = new StringBuilder();
        for (String word : uniqueWords) {
            result.append(word).append(" ");
        }
        
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        System.out.println("Результат после удаления дубликатов:");
        System.out.println(result.toString());
        
        scanner.close();
    }
}
