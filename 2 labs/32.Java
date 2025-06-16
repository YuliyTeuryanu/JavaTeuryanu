import java.util.Scanner;

class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите индекс i (10 ≤ i ≤ 100000): ");
            int i = scanner.nextInt();
            
            if (i < 10 || i > 100000) {
                System.out.println("Индекс должен быть в диапазоне 10 ≤ i ≤ 100000");
                return;
            }
            
            String fibonacciNumber = computeLargeFibonacci(i);
            
            int[] result = findMostFrequentDigit(fibonacciNumber);
            
            System.out.printf("f(%d) = %s\n", i, fibonacciNumber);
            System.out.printf("Результат: [(%d, %d)]\n", result[0], result[1]);
        }
    }
    
    public static String computeLargeFibonacci(int n) {
        if (n == 0) return "0";
        
        String a = "0";
        String b = "1";
        
        for (int i = 2; i <= n; i++) {
            String temp = addLargeNumbers(a, b);
            a = b;
            b = temp;
        }
        
        return b;
    }
    
    public static String addLargeNumbers(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10);
        }
        
        return result.toString();
    }
    
    public static int[] findMostFrequentDigit(String number) {
        int[] digitCounts = new int[10];
        
        for (char c : number.toCharArray()) {
            int digit = c - '0';
            digitCounts[digit]++;
        }
        
        int maxCount = -1;
        int mostFrequentDigit = -1;
        
        for (int digit = 0; digit < 10; digit++) {
            if (digitCounts[digit] > maxCount || 
                (digitCounts[digit] == maxCount && digit < mostFrequentDigit)) {
                maxCount = digitCounts[digit];
                mostFrequentDigit = digit;
            }
        }
        
        return new int[]{maxCount, mostFrequentDigit};
    }
}
