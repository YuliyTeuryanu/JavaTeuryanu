import java.util.Scanner;

class NumberSeriesSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        
        int start = Math.min(num1, num2);
        int end = Math.max(num1, num2);
        
        System.out.print("Квадраты чисел: ");
        
        for (int i = start; i <= end; i++) {
            System.out.print(i * i);
            if (i < end) {
                System.out.print(", ");
            }
        }
        
        scanner.close();
    }
}
