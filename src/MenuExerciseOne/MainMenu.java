package MenuExerciseOne;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void startMenu() throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            int option = interfaceMenuOption();
            switch (option) {
                case 1:
                    CalculatorMenu calculatorMenu = new CalculatorMenu();
                    calculatorMenu.startCalculator();
                    break;
                case 2:
                    EncoderMenu encoderMenu = new EncoderMenu();
                    encoderMenu.startEncoder();
                    break;
                case 3:
                    // Implement student average calculator functionality
                    System.out.println("Student average calculator functionality not implemented yet.");
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private int interfaceMenuOption() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("                              ");
        System.out.println("   Jose Luis Ramirez Larios");
        System.out.println("------------------------------");
        System.out.println("|                            |");
        System.out.println("|                            |");
        System.out.println("|     Welcome to the menu    |");
        System.out.println("|   Please choose an option: |");
        System.out.println("|                            |");
        System.out.println("| 1. BASIC CALCULATOR        |");
        System.out.println("| 2. ENCODER                 |");
        System.out.println("| 3. STUDENT AVERAGE CALC    |");
        System.out.println("| 0. EXIT                    |");
        System.out.println("|                            |");
        System.out.println("------------------------------");
        System.out.print(">> ");
        return getUserInput();
    }

    public int getUserInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
