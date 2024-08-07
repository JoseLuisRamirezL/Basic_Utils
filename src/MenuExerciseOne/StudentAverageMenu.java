package MenuExerciseOne;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentAverageMenu{
    private final Scanner scanner = new Scanner(System.in);
    private String name;
    private int signatures;
    private String grade;
    private String[] signaturesNames = new String[signatures];
    private double[] signaturesGrades = new double[signatures];

    public void startMenuStudentAverage() {
        try {

            System.out.println("Please enter your name:");
            name = scanner.nextLine();

            System.out.println("Please enter your grade:");
            grade = scanner.next();

            System.out.println("Please enter the number of signatures to enroll:");
            signatures = scanner.nextInt();
            scanner.nextLine();

            signaturesGrades = new double[signatures];
            signaturesNames = new String[signatures];

            IntStream.range(0, signatures)
                    .forEach(i -> {
                        System.out.println("Enter the name of the signature " + (i + 1) + ":");
                        signaturesNames[i] = scanner.nextLine();
                        System.out.println("Enter the score for " + signaturesNames[i] + ":");
                        signaturesGrades[i] = scanner.nextDouble();
                        scanner.nextLine();
                    });
            printOutput();
        } catch (Exception e) {
            System.out.println("An error has occurred" + e.getMessage());
            System.out.println("Back to the Main Menu...");
        }
    }

    private void printOutput(){
        System.out.println();
        System.out.println();
        System.out.println(createLine());
        String format = "Student name: %-40s Grade: %s%n";
        String format2 = "    Signature: %-39s Score: %.1f%n";
        System.out.printf(format, name, grade);
        System.out.println(createLine());
        IntStream.range(0, signatures)
                .forEach(i -> {
                    System.out.printf(format2, signaturesNames[i], signaturesGrades[i]);
                });
        System.out.println(createLine());
        if (signatureAverage() <= 5 && signatureAverage() >= 0 ){
            System.out.printf("Final average: %.2f             Status: Not passed" ,signatureAverage());
        }
        else if (signatureAverage() >= 6 && signatureAverage() <= 7 ){
            System.out.printf("Final average: %.2f             Status: Passed with regular level" ,signatureAverage());
        } else if (signatureAverage() >= 8 && signatureAverage() <=9) {
            System.out.printf("Final average: %.2f             Status: Passed with good level" ,signatureAverage());
        } else if (signatureAverage() > 9 && signatureAverage() <= 10 ) {
            System.out.printf("Final average: %.2f             Status: Passed with perfect level", signatureAverage());
        } else {
            System.out.println("Error, you didn't enter values from 1 to 10, back to the main menu...");
        }
    }

    private double signatureAverage(){
        return Arrays.stream(signaturesGrades).average().getAsDouble();
    }

    private String createLine(){
        return IntStream.range(0, 70)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

}
