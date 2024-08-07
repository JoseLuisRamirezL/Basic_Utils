package MenuExerciseOne;

import java.util.Base64;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EncoderMenu extends MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void startEncoder() {
        System.out.println("Please choose an option:");
        System.out.println("1. Encode a String to Base64");
        System.out.println("2. Decode a String to Base64");
        int choice = getUserInput();
        try {
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Please enter the string to encode");
                        String inputString = scanner.nextLine();
                        Base64.Encoder encoder = Base64.getEncoder();
                        String encodedString = encoder.encodeToString(inputString.getBytes());
                        System.out.println("Encoded String is: " + encodedString);
                    } catch (IllegalArgumentException e){
                        System.out.println("Invalid input. Back to the Main Menu...");
                    }
                    break;
                case 2:
                    try{
                        System.out.println("Please enter the string to decode");
                        String inputStringDecode = scanner.nextLine();
                        Base64.Decoder decoder = Base64.getDecoder();
                        byte[] decodedBytes = decoder.decode(inputStringDecode);
                        String decodedString = new String(decodedBytes);
                        System.out.println("Decoded String is: " + decodedString);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input. Back to the Main Menu...");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Back to the Main Menu....");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.print("Invalid input. Back to the Main Menu....");
        }
    }
}
