import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class FitnessSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите веса через пробел:");
        String input = scanner.nextLine();
        
        String[] weights = input.split(" ");
        
        Arrays.sort(weights, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int sumA = sumOfDigits(a);
                int sumB = sumOfDigits(b);
                
                if (sumA != sumB) {
                    return Integer.compare(sumA, sumB);
                }
                return 0;
            }
            
            private int sumOfDigits(String number) {
                int sum = 0;
                for (int i = 0; i < number.length(); i++) {
                    char c = number.charAt(i);
                    if (Character.isDigit(c)) {
                        sum += Character.getNumericValue(c);
                    }
                }
                return sum;
            }
        });
        
        System.out.println("Отсортированный список:");
        System.out.println(String.join(" ", weights));
        
        scanner.close();
    }
}
