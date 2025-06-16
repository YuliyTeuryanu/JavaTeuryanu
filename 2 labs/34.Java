import java.util.Scanner;

public class StickGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество палочек (1 ≤ n ≤ 10^18): ");
            long n = scanner.nextLong();
            
            if (n < 1) {
                System.out.println("Количество палочек должно быть ≥ 1");
                return;
            }
            
     
            long tanyaSticks = playGame(n);
            
            System.out.println("Количество палочек у Тани: " + tanyaSticks);
        }
    }
    
    public static long playGame(long n) {
        long tanyaSticks = 0;
        boolean isTanyaTurn = true; 
        
        while (n > 0) {
            long taken = getMaxMove(n);
            
            if (isTanyaTurn) {
                tanyaSticks += taken;
            }
            
            n -= taken;
            isTanyaTurn = !isTanyaTurn; 
        }
        
        return tanyaSticks;
    }
    
    private static long getMaxMove(long n) {
        if (n % 2 == 1) {
            
            return 1;
        } else {
           
            return Math.max(1, n / 2);
        }
    }
}
