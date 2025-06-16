import java.util.ArrayList;
import java.util.List;

class SnailSort {

    public static int[] snail(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<>();
        int n = array.length;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Движение вправо по верхней строке
            for (int i = colStart; i <= colEnd; i++) {
                result.add(array[rowStart][i]);
            }
            rowStart++;

            // Движение вниз по правому столбцу
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(array[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                // Движение влево по нижней строке
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(array[rowEnd][i]);
                }
                rowEnd--;
            }

            if (colStart <= colEnd) {
                // Движение вверх по левому столбцу
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(array[i][colStart]);
                }
                colStart++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] array1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] result1 = snail(array1);
        System.out.println(java.util.Arrays.toString(result1)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]

        int[][] array2 = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };
        int[] result2 = snail(array2);
        System.out.println(java.util.Arrays.toString(result2)); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
