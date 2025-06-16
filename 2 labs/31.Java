import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите расстояния до городов через пробел:");
            String[] input = scanner.nextLine().split(" ");
            List<Integer> distances = new ArrayList<>();
            for (String s : input) {
                distances.add(Integer.parseInt(s));
            }

            System.out.print("Введите максимальное расстояние (175): ");
            int maxDistance = scanner.nextInt();

            System.out.print("Введите количество городов для посещения (3): ");
            int citiesToVisit = scanner.nextInt();

            Integer bestSum = chooseBestSum(maxDistance, citiesToVisit, distances);

            if (bestSum != null) {
                System.out.println("Максимально возможная сумма расстояний: " + bestSum);
            } else {
                System.out.println("Невозможно найти подходящую комбинацию городов");
            }
        }
    }

    public static Integer chooseBestSum(int maxDistance, int citiesToVisit, List<Integer> distances) {
        List<List<Integer>> combinations = generateCombinations(distances, citiesToVisit);

        int bestSum = -1;
        
        for (List<Integer> combination : combinations) {
            int currentSum = combination.stream().mapToInt(Integer::intValue).sum();
            
            if (currentSum <= maxDistance && currentSum > bestSum) {
                bestSum = currentSum;
            }
        }

        return bestSum == -1 ? null : bestSum;
    }

    private static List<List<Integer>> generateCombinations(List<Integer> elements, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsHelper(elements, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(List<Integer> elements, int k, int start, 
                                                 List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < elements.size(); i++) {
            current.add(elements.get(i));
            generateCombinationsHelper(elements, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
