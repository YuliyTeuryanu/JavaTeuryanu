import java.util.Scanner;

class UltraSimpleMemory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] memory = new int[3]; 
        int filled = 0; 

        System.out.println("Простая программа для хранения 3 чисел");
        System.out.println("Вводите числа по одному (для выхода введите любой нечисловой символ)");

        while (scanner.hasNextInt()) {
            System.out.print("Введи число: ");
            int number = scanner.nextInt();
            
            if (filled < 3) {
                memory[filled] = number;
                filled++;
            } else {
                int minIndex = 0;
                if (memory[1] < memory[minIndex]) minIndex = 1;
                if (memory[2] < memory[minIndex]) minIndex = 2;
                
                if (number > memory[minIndex]) {
                    memory[minIndex] = number;
                }
            }
            
            System.out.print("Сохраненные числа: ");
            for (int i = 0; i < filled; i++) {
                System.out.print(memory[i] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Программа завершена. Вот итоговые числа:");
        for (int i = 0; i < filled; i++) {
            System.out.print(memory[i] + " ");
        }
        
        scanner.close();
    }
}
