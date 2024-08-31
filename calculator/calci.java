import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("Welcome to the Calculator!");
            double num1 = getNumber("Enter the first number: ");
            double num2 = getNumber("Enter the second number: ");

            System.out.println("Select operation: ");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root of First Number");
            System.out.println("6. Power");
            System.out.println("7. Percentage");
            System.out.println("8. Exit");

            int choice = getChoice("Enter choice (1/2/3/4/5/6/7/8): ");
            double result = 0;
            
            switch (choice) {
                case 1:
                    result = num1 + num2;
                    System.out.println("The result of addition is: " + result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("The result of subtraction is: " + result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("The result of multiplication is: " + result);
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("The result of division is: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                case 5:
                    if (num1 >= 0) {
                        result = Math.sqrt(num1);
                        System.out.println("The square root of " + num1 + " is: " + result);
                    } else {
                        System.out.println("Error: Square root of a negative number is not allowed.");
                    }
                    break;
                case 6:
                    result = Math.pow(num1, num2);
                    System.out.println(num1 + " raised to the power of " + num2 + " is: " + result);
                    break;
                case 7:
                    result = (num1 * num2) / 100;
                    System.out.println(num1 + " is " + result + "% of " + num2);
                    break;
                case 8:
                    continueCalculating = false;
                    System.out.println("Exiting the calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
                    break;
            }
        }

        scanner.close();
    }

    private static double getNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                number = scanner.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return number;
    }

    private static int getChoice(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 8) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Please select a number between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return choice;
    }
}
