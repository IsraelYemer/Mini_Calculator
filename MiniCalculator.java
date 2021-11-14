import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * This a simple calculator that calculates two or three values depending on user input.
 * */

public class MiniCalculator {

    // subtraction method
    public static double subtraction(double firstNum, double secondNum) {
        double subtractionResult;
        subtractionResult = firstNum - secondNum;
        return subtractionResult;
    }

    // addition method
    public static double addition(double firstNum, double secondNum) {
        double additionResult;
        additionResult = firstNum + secondNum;
        return additionResult;
    }

    // division method
    public static double division(double firstNum, double secondNum) {
        double divisionResult;
        divisionResult = firstNum / secondNum;
        return divisionResult;

    }

    // multiplication method
    public static double multiplication(double firstNum, double secondNum) {
        double multiplicationResult;
        multiplicationResult = firstNum * secondNum;
        return multiplicationResult;
    }

    // Divider validating method
    public static boolean isDividerValid(double divider) {
        if (divider == 0) {
            return false;
        }
        return true;
    }

    // Three value calculator method
    public static double doMath(double firstNum, double secondNum, double thirdNum, char operator1, char operator2) {

        switch (operator1) {
            case '+':
                switch (operator2) {
                    case '-':
                        return firstNum + secondNum - thirdNum;
                    case '*':
                        return firstNum + secondNum * thirdNum;
                    case '/':
                        return firstNum + secondNum / thirdNum;
                    case '+':
                        return firstNum + secondNum + thirdNum;
                    default:
                        return 0;
                }

            case '-':
                switch (operator2) {
                    case '+':
                        return firstNum - secondNum + thirdNum;
                    case '*':
                        return firstNum - secondNum * thirdNum;
                    case '/':
                        return firstNum - secondNum / thirdNum;
                    case '-':
                        return firstNum - secondNum - thirdNum;
                    default:
                        return 0;
                }
            case '/':
                switch (operator2) {
                    case '-':
                        return firstNum / secondNum - thirdNum;
                    case '*':
                        return firstNum / secondNum * thirdNum;
                    case '+':
                        return firstNum / secondNum + thirdNum;
                    case '/':
                        return firstNum / secondNum / thirdNum;
                    default:
                        return 0;
                }

            case '*':
                switch (operator2) {
                    case '+':
                        return firstNum * secondNum + thirdNum;
                    case '-':
                        return firstNum * secondNum - thirdNum;
                    case '/':
                        return firstNum * secondNum / thirdNum;
                    case '*':
                        return firstNum * secondNum * thirdNum;
                    default:
                        return 0;
                }
            default:
                return 0;
        }
    }

    // Main class
    public static void main(String[] args) {

        String operator1;
        String operator2;
        double firstNum;
        double secondNum;
        double thirdNum;
        double result;

        // Initialize scanner object
        Scanner userInput = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("###.#");

        // Ask the user to input the first numbers
        System.out.println("Please enter the first number");
        // Store the first number
        firstNum = userInput.nextDouble();

        // Ask the user to select operator1
        System.out.println("Please enter + for addition, - for subtraction, * for multiplication, / for division");
        operator1 = userInput.next();
        userInput.nextLine();

        // Ask the user to input the second numbers
        System.out.println("Please enter the second number");
        // Store the second number
        secondNum = userInput.nextDouble();

        // Ask the user to select operator2
        System.out.println("Please enter + for addition, - for subtraction, * for multiplication, / for division or N if not needed");
        operator2 = userInput.next();

        if (operator2.equals("N")) {

            switch (operator1) {
                case "+":
                    // Invoke addition method
                    result = MiniCalculator.addition(firstNum, secondNum);
                    // Output the result and don't show the .0 if the result is not double
                    System.out.println("Result is " + decimalFormat.format(result));
                    break;
                case "-":
                    // Invoke subtraction method
                    result = MiniCalculator.subtraction(firstNum, secondNum);
                    // Output the result and don't show the .0 if the result is not double
                    System.out.println("Result is " + result);
                    break;
                case "*":
                    // Invoke multiplication method
                    result = MiniCalculator.multiplication(firstNum, secondNum);
                    // Output the result and don't show the .0 if the result is not double
                    System.out.println("Result is " + decimalFormat.format(result));
                    break;
                case "/":
                    // validate divider
                    while (!MiniCalculator.isDividerValid(secondNum)) {
                        // Ask the user to input the second numbers
                        System.out.println(decimalFormat.format(secondNum) + " can't be a divider. Please enter the second number");
                        // Store the second number
                        secondNum = userInput.nextDouble();
                    }
                    // Invoke division method
                    result = MiniCalculator.division(firstNum, secondNum);
                    // Output the result and don't show the .0 if the result is not double
                    System.out.println("Result is " + decimalFormat.format(result));
                    break;
                default:
                    System.out.println("Invalid operator");
            }

        } else {
            // Ask the user to input the third numbers
            System.out.println("Please enter the third number");
            // Store the second number
            thirdNum = userInput.nextDouble();

            userInput.nextLine();
            // Store all inputs into a char array
            char userInputArrey[] = { (char) firstNum, operator1.charAt(0), (char) secondNum, operator2.charAt(0),
                    (char) thirdNum };
            String listOfInput = new String(userInputArrey);
            // Find index of / if exist
            int index = new String(userInputArrey).indexOf("/");
            // locate the element after index is 0
            int numberAfterIndex = index + 1;
            char x = listOfInput.charAt(numberAfterIndex);
            if (x == 0) {
                // Validate divisor
                while (!MiniCalculator.isDividerValid(thirdNum)) {
                    // Ask the user to re input third the numbers
                    System.out.println(
                            decimalFormat.format(thirdNum) + " can't be a divisor. Please enter the third number");
                    // Store the second number
                    thirdNum = userInput.nextDouble();
                }
                result = MiniCalculator.doMath(firstNum, secondNum, thirdNum, operator1.charAt(0), operator2.charAt(0));

            } else {
                result = MiniCalculator.doMath(firstNum, secondNum, thirdNum, operator1.charAt(0), operator2.charAt(0));
            }
            // Output the result and don't show the .0 if the result is not double
            System.out.println("Result is " + decimalFormat.format(result));
        }
        // Close Scanner
        userInput.close();
    }
}

