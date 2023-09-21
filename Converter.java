import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        switch (choice) {
            case 1:
                binaryToDecimalConversion(scanner);
                break;
            case 2:
                decimalToBinaryConversion(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }

    // Function to check if the input is a valid binary number
    public static boolean isValidBinary(String binaryString) {
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    // Function to convert a binary string to a decimal integer
    public static int binaryToDecimal(String binaryString) {
        int decimalValue = 0;
        int binaryLength = binaryString.length();

        for (int i = 0; i < binaryLength; i++) {
            char bit = binaryString.charAt(i);
            int power = binaryLength - 1 - i;
            if (bit == '1') {
                decimalValue += Math.pow(2, power);
            }
        }

        return decimalValue;
    }

    // Function to convert a decimal integer to a binary string
    public static String decimalToBinary(int decimalValue) {
        if (decimalValue == 0) {
            return "0";
        }

        StringBuilder binaryString = new StringBuilder();
        while (decimalValue > 0) {
            int remainder = decimalValue % 2;
            binaryString.insert(0, remainder);
            decimalValue /= 2;
        }

        return binaryString.toString();
    }

    // Function for binary to decimal conversion
    public static void binaryToDecimalConversion(Scanner scanner) {
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();

        // Check if the input is a valid binary number
        if (isValidBinary(binaryString)) {
            int decimalValue = binaryToDecimal(binaryString);
            System.out.println("Decimal equivalent: " + decimalValue);
        } else {
            System.out.println("Invalid binary number.");
        }
    }

    // Function for decimal to binary conversion
    public static void decimalToBinaryConversion(Scanner scanner) {
        System.out.print("Enter a decimal number: ");
        int decimalValue = scanner.nextInt();
        
        if (decimalValue < 0) {
            System.out.println("Decimal number must be non-negative.");
        } else {
            String binaryString = decimalToBinary(decimalValue);
            System.out.println("Binary equivalent: " + binaryString);
        }
    }
}
