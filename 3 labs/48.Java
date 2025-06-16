import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

class SequenceGenerator {
    public static void generateSequence(int n) {
        if (n <= 0) {
            System.out.println("[]");
            return;
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        // Начальное значение
        queue.add(1L);
        seen.add(1L);
        
        System.out.print("[1");
        
        for (int i = 1; i < n; i++) {
            long current = queue.poll();
            long y = 2 * current + 1;
            long z = 3 * current + 1;
            
            // Добавляем новые значения, если их еще нет
            if (!seen.contains(y)) {
                queue.add(y);
                seen.add(y);
            }
            if (!seen.contains(z)) {
                queue.add(z);
                seen.add(z);
            }
            
            // Печатаем следующее число в последовательности
            System.out.print(", " + queue.peek());
        }
        
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Генерируем первые 15 элементов последовательности
        generateSequence(15);
    }
}
