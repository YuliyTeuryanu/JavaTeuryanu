import java.util.Scanner;

class TextTransformer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите текст:");
        String input = scanner.nextLine();
        
        String transformed = transformText(input);
        System.out.println("Результат:");
        System.out.println(transformed);
        
        scanner.close();
    }

    public static String transformText(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] parts = text.split("(?<=\\b)|(?=\\b)");
        
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (isWord(part)) {
                parts[i] = transformWord(part);
            }
        }
        
        return String.join("", parts);
    }

    private static boolean isWord(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return s.chars().anyMatch(Character::isLetter);
    }

    private static String transformWord(String word) {
        if (word.length() == 0) {
            return word;
        }

        char firstChar = word.charAt(0);
        if (Character.isLetter(firstChar)) {
            return word.substring(1) + firstChar + "ауч";
        }
        
        return word;
    }
}
