import java.util.HashMap;
import java.util.Map;

class RomanToArabicConverter {
    private static final Map<Character, Integer> ROMAN_VALUES = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int convertToArabic(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Римское число не может быть пустым");
        }

        int total = 0;
        int prevValue = 0;


        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.toUpperCase().charAt(i);
            if (!ROMAN_VALUES.containsKey(currentChar)) {
                throw new IllegalArgumentException("Недопустимый символ в римском числе: " + currentChar);
            }

            int currentValue = ROMAN_VALUES.get(currentChar);


            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }


        if (total <= 1 || total >= 10000) {
            throw new IllegalArgumentException("Число должно быть в диапазоне 1 < n < 10000");
        }

        return total;
    }

    public static void main(String[] args) {

        System.out.println("X → " + convertToArabic("X"));       
        System.out.println("V → " + convertToArabic("V"));         

    }
}
