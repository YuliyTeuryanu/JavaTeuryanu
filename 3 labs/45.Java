class ArabicToRomanSimple {
    public static String toRoman(int number) {
        if (number <= 1 || number >= 10000) {
            return "Введите число от 2 до 9999";
        }

  
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        

        for (int i = 0; i < values.length; i++) {

            while (number >= values[i]) {
                roman.append(numerals[i]);
                number -= values[i];
            }
        }
        
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println("5 → " + toRoman(5));      
        System.out.println("10 → " + toRoman(10));      
        System.out.println("58 → " + toRoman(58));    
        System.out.println("1994 → " + toRoman(1994)); 
    }
}
