import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            
            System.out.println("Введите количество игроков:");
            int n = scanner.nextInt();
            
            System.out.println("Введите номер игрока, с которого начинается игра:");
            int k = scanner.nextInt();
            
            if (n <= 0 || k <= 0 || k > n) {
                System.out.println("Некорректные входные данные!");
                return;
            }
            
            List<Integer> players = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                players.add(i);
            }
            
            List<Integer> result = new ArrayList<>();
            
            int currentIndex = k - 1;
            
            while (players.size() > 1) {
                currentIndex = (currentIndex + 2) % players.size();
                
                int eliminated = players.remove(currentIndex);
                result.add(eliminated);
                
                System.out.println(players + " => " + eliminated + " выбывает и добавляется в результат " + result);
            }
            
            if (!players.isEmpty()) {
                int winner = players.get(0);
                result.add(winner);
                System.out.println("[] => " + winner + " выбывает и добавляется в результат " + result);
            }
            
            System.out.println("\nИтоговый порядок выбывания:");
            System.out.println(result);
            
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
