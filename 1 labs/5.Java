import java.util.Scanner;

class NumberSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите начало ряда: ");
        int start = scanner.nextInt();
        
        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();
        
        System.out.print("Введите количество шагов: ");
        int count = scanner.nextInt();
        
        System.out.print("Числа ряда: ");
        
        for (int i = 0; i < count; i++) {
            int current = start + i * step;
            System.out.print(current);
            
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        
        scanner.close();
    }
}
