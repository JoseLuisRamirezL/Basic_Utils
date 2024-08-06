package MenuExerciseOne;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMenu {
    private Scanner scanner = new Scanner(System.in);

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
            double result = 0;
            switch (choice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. Back to the Main Menu....");
        }
    }

    private int getUserInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
