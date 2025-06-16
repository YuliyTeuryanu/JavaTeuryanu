class FuscSequence {

    public static int fusc(int n) {
        // a = fusc(k), b = fusc(k+1)
        int a = 0; // fusc(0)
        int b = 1; // fusc(1)

        while (n > 0) {
            if (n % 2 == 0) {
                // Если n четное, то fusc(n) = fusc(n/2)
                b = a + b; // обновляем b для следующего шага
            } else {
                // Если n нечетное, fusc(n) = fusc((n-1)/2) + fusc((n+1)/2)
                a = a + b; // обновляем a для следующего шага
            }
            n = n / 2;
        }

        return a;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("fusc(" + i + ") = " + fusc(i));
        }
    }
}
