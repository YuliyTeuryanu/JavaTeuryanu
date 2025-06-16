import java.util.Scanner;

class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число: ");
            int number = scanner.nextInt();
            
            System.out.print("Введите начальную степень: ");
            int startPower = scanner.nextInt();
            
            if (number <= 0 || startPower <= 0) {
                System.out.println("Число и начальная степень должны быть положительными");
                return;
            }
            
            checkSpecialCondition(number, startPower);
        }
    }
    
    public static void checkSpecialCondition(int number, int startPower) {
        String numStr = Integer.toString(number);
        int sum = 0;
        int currentPower = startPower;
        
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, currentPower);
            currentPower++;
        }
        
        if (sum % number == 0) {
            int multiplier = sum / number;
            System.out.printf("Условие выполняется: сумма = %d = %d * %d%n", sum, number, multiplier);
            
            System.out.print("Подробно: ");
            currentPower = startPower;
            for (int i = 0; i < numStr.length(); i++) {
                int digit = Character.getNumericValue(numStr.charAt(i));
                if (i > 0) System.out.print(" + ");
                System.out.printf("%d^%d", digit, currentPower);
                currentPower++;
            }
            System.out.printf(" = %d%n", sum);
        } else {
            System.out.printf("Условие не выполняется: сумма = %d, но %d не делится на %d%n", sum, sum, number);
        }
    }
}
