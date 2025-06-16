import java.util.Scanner;

class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите начальное количество палочек (1 ≤ n ≤ 10^18): ");
            long n = scanner.nextLong();
            
            if (n < 1) {
                System.out.println("Количество палочек должно быть ≥ 1");
                return;
            }
            
            // Определяем победителя
            String winner = determineWinner(n);
            
            System.out.println("Победитель: " + winner);
        }
    }
    
    public static String determineWinner(long n) {
        // Игрок 1 (Саша) начинает первым
        boolean isSashaTurn = true;
        
        while (n > 0) {
            long move = getOptimalMove(n);
            n -= move;
            
            // Если после хода палочек не осталось - текущий игрок победил
            if (n == 0) {
                return isSashaTurn ? "Саша" : "Таня";
            }
            
            // Передаем ход другому игроку
            isSashaTurn = !isSashaTurn;
        }
        
        // Этот return никогда не выполнится из-за условия в цикле
        return "Ничья";
    }
    
    private static long getOptimalMove(long n) {
        if (n % 2 == 1) {
            // Нечетное количество - берем 1 палочку
            return 1;
        } else {
            // Четное количество - выбираем оптимальный ход
            // Если n/2 нечетное или равно 2 - берем половину
            // Иначе берем 1 палочку
            long half = n / 2;
            return (half % 2 == 1 || half == 2) ? half : 1;
        }
    }
}
