package MenuExerciseOne;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.BiFunction;

public class CalculatorMenu extends MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void startCalculator() {
        System.out.println("Please choose an option: ");
        System.out.println("1. Sum");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print(">> ");
        int choice = getUserInput();
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            double result;
            switch (choice) {
                case 1:
                    BiFunction<Double, Double, Double> sum = (a, b) -> a + b;
                    result = sum.apply(num1, num2);
                    System.out.println(result);
                    break;
                case 2:
                    BiFunction<Double, Double, Double> sub = (a, b) -> a - b;
                    result = sub.apply(num1, num2);
                    System.out.println(result);
                    break;
                case 3:
                    BiFunction<Double, Double, Double> mul = (a, b) -> a * b;
                    result = mul.apply(num1, num2);
                    System.out.println(result);
                    break;
                case 4:
                    if (num2 != 0) {
                        BiFunction<Double, Double, Double> div = (a, b) -> a / b;
                        result = div.apply(num1, num2);
                        System.out.println(result);
                    } else {
                        System.out.println("Error: Division by zero.");
                        System.out.print("Invalid input. Back to the Main Menu....");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid option. Back to the Main Menu....");
                    return;
            }
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. Back to the Main Menu....");
        }
    }
}
