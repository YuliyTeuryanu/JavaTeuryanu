import java.util.Scanner;

class CaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите строку для анализа:");
        String input = scanner.nextLine();
        
        int upperCount = 0;
        int lowerCount = 0;
        
        // Подсчет количества заглавных и строчных букв
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }
        
        String result;
        if (upperCount > lowerCount) {
            result = input.toUpperCase();
        } else if (lowerCount > upperCount) {
            result = input.toLowerCase();
        } else {
            result = input.toLowerCase();  // при равенстве преобразуем к нижнему
        }
        
        System.out.println("Результат преобразования:");
        System.out.println(result);
        
        scanner.close();
    }
}
