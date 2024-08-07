package MenuExerciseOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class StudentAverageMenu{
    private final Scanner scanner = new Scanner(System.in);
    private String name;
    private int signatures;
    private int grade;

    public void startMenuStudentAverage() {
        System.out.println("Please enter your name:");
        name = scanner.nextLine();

        System.out.println("Please enter your grade:");
        grade = scanner.nextInt();

        System.out.println("Please enter the number of signatures to enroll:");
        signatures = scanner.nextInt();
        scanner.nextLine();

        String[] signaturesNames = IntStream.range(0, signatures)
                .mapToObj(i -> {
                    System.out.println("Enter the name of the signature " + (i + 1) + ": ");
                    return scanner.nextLine();
                })
                .toArray(String[]::new);

        int[] signaturesGrades = IntStream.range(0, signatures)
                        .map(i -> {
                            System.out.println("Enter the grade of the signature " + signaturesNames[i] + ": ");
                            return scanner.nextInt();
                        })
                        .toArray();

        System.out.println(Arrays.toString(signaturesNames));
        System.out.println(Arrays.toString(signaturesGrades));
    }
}
