import java.util.Scanner;

class App  {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число n (0 < n < 100000): ");
            int n = scanner.nextInt();
            
            if (n <= 0 || n >= 100000) {
                System.out.println("Число должно быть в диапазоне 0 < n < 100000");
                return;
            }
            
            findConsecutiveSquares(n);
        }
    }
    
    public static void findConsecutiveSquares(int n) {
        if (n % 2 != 1) {
            System.out.println("Для четных чисел не существует последовательных квадратов с такой разницей");
            return;
        }
        
        int k = (n - 1) / 2;
        int square1 = k * k;
        int square2 = (k + 1) * (k + 1);
        
        System.out.printf("%d = %d - %d\n", n, square2, square1);
    }
}
