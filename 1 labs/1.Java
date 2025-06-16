import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        boolean endsWith = first.endsWith(second);

        System.out.println(endsWith);
        
        scanner.close();
    }
}

