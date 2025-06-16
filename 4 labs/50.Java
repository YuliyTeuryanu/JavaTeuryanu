import java.io.*;
import java.util.*;
import java.util.regex.*;

class Calculator {
    private static final String HISTORY_FILE = "calculator_history.txt";
    private static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        loadHistory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nКалькулятор. Доступные операции: + - * / // % ^ | |");
            System.out.println("Введите уравнение (или 'history' для просмотра истории, 'exit' для выхода):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("history")) {
                showHistory();
                continue;
            }

            try {
                double result = evaluateExpression(input);
                System.out.println("Результат: " + result);
                
                // Сохраняем уравнение и результат в историю
                String entry = input + " = " + result;
                history.add(entry);
                saveToHistory(entry);
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static double evaluateExpression(String expression) throws Exception {
        // Обрабатываем модули |число|
        expression = processAbsoluteValues(expression);
        
        // Обрабатываем скобки
        expression = processParentheses(expression);
        
        // Обрабатываем степени
        expression = processOperations(expression, new String[]{"^"});
        
        // Обрабатываем умножение, деление, остаток и целочисленное деление
        expression = processOperations(expression, new String[]{"*", "/", "%", "//"});
        
        // Обрабатываем сложение и вычитание
        expression = processOperations(expression, new String[]{"+", "-"});
        
        return Double.parseDouble(expression);
    }

    private static String processAbsoluteValues(String expr) throws Exception {
        Pattern pattern = Pattern.compile("\\|([^|]+)\\|");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateExpression(inside);
            expr = expr.replace(matcher.group(), String.valueOf(Math.abs(value)));
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }

    private static String processParentheses(String expr) throws Exception {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateExpression(inside);
            expr = expr.replace(matcher.group(), String.valueOf(value));
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }

    private static String processOperations(String expr, String[] operations) throws Exception {
        Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)([\\" + String.join("\\", operations) + "])(-?\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            double left = Double.parseDouble(matcher.group(1));
            String op = matcher.group(2);
            double right = Double.parseDouble(matcher.group(3));
            double result = performOperation(left, op, right);
            
            expr = expr.replace(matcher.group(), String.valueOf(result));
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }

    private static double performOperation(double left, String op, double right) throws Exception {
        switch (op) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": 
                if (right == 0) throw new ArithmeticException("Деление на ноль");
                return left / right;
            case "//": 
                if (right == 0) throw new ArithmeticException("Деление на ноль");
                return Math.floor(left / right);
            case "%": return left % right;
            case "^": return Math.pow(left, right);
            default: throw new Exception("Неизвестная операция: " + op);
        }
    }

    private static void loadHistory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            // Файл не существует или ошибка чтения - просто продолжим
        }
    }

    private static void saveToHistory(String entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Не удалось сохранить историю: " + e.getMessage());
        }
    }

    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("История пуста.");
            return;
        }
        
        System.out.println("\nИстория операций:");
        for (String entry : history) {
            System.out.println(entry);
        }
    }
}
