import java.io.*;
import java.util.*;

public class Solution_005 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        /* Camel Case is a naming style common in many programming languages.
        In Java, method and variable names typically start with a lowercase letter,
        with all subsequent words starting with a capital letter (example: startThread).
        Names of classes follow the same pattern, except that they start with a capital letter (example: BlueCar).

        Your task is to write a program that creates or splits Camel Case variable,
        method, and class names.

        Input Format

        Each line of the input file will begin with an operation (S or C)
        followed by a semi-colon followed by M, C, or V followed by a semi-colon
        followed by the words you'll need to operate on.
        The operation will either be S (split) or C (combine)
        M indicates method, C indicates class, and V indicates variable
        In the case of a split operation, the words will be a camel case method,
        class or variable name that you need to split into
        a space-delimited list of words starting with a lowercase letter.
        In the case of a combine operation, the words will be a space-delimited list of words
        starting with lowercase letters that you need to combine into the appropriate camel case String.
        Methods should end with an empty set of parentheses to differentiate them from variable names.
        Output Format

        For each input line, your program should print either the space-delimited list of words
        (in the case of a split operation) or the appropriate camel case string (in the case of a combine operation).
        Sample Input

        S;M;plasticCup()

        C;V;mobile phone

        C;C;coffee machine

        S;C;LargeSoftwareBook

        C;M;white sheet of paper

        S;V;pictureFrame

        Sample Output

        plastic cup

        mobilePhone

        CoffeeMachine

        large software book

        whiteSheetOfPaper()

        picture frame

        Explanation

        Use Scanner to read in all information as if it were coming from the keyboard.

        Print all information to the console using standard output (System.out.print() or System.out.println()).

        Outputs must be exact (exact spaces and casing).*/

        // only for local environment
        runTests();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            processInput(line);
        }

        scanner.close();
    }

    private static void processInput(String input) {
        String[] parts = input.split(";");
        String operation = parts[0];
        String category = parts[1];
        String value = parts[2];

        if (operation.equals("S")) {
            splitAndPrint(category, value);
        } else if (operation.equals("C")) {
            combineAndPrint(category, value);
        }
    }

    private static void splitAndPrint(String category, String value) {
        if (category.equals("M")) {
            System.out.println(splitMethod(value));
        } else if (category.equals("C")) {
            System.out.println(splitClass(value));
        } else if (category.equals("V")) {
            System.out.println(splitVariable(value));
        }
    }

    private static String splitMethod(String value) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (Character.isUpperCase(c)) {
                output.append(" ").append(Character.toLowerCase(c));
            } else if (c != '(' && c != ')') {
                output.append(c);
            }
        }

        return output.toString().trim();
    }

    private static String splitClass(String value) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (i == 0) {
                output.append(Character.toLowerCase(c));
            } else if (Character.isUpperCase(c)) {
                output.append(" ").append(Character.toLowerCase(c));
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    private static String splitVariable(String value) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (i == 0) {
                output.append(Character.toLowerCase(c));
            } else if (Character.isUpperCase(c)) {
                output.append(" ").append(Character.toLowerCase(c));
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    private static void combineAndPrint(String category, String value) {
        if (category.equals("M")) {
            System.out.println(combineMethod(value));
        } else if (category.equals("C")) {
            System.out.println(combineClass(value));
        } else if (category.equals("V")) {
            System.out.println(combineVariable(value));
        }
    }

    private static String combineMethod(String value) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (i == 0) {
                output.append(Character.toLowerCase(c));
            } else if (Character.isWhitespace(c)) {
                output.append(Character.toUpperCase(value.charAt(i + 1)));
                i++;
            } else {
                output.append(c);
            }
        }

        output.append("()");

        return output.toString();
    }

    private static String combineClass(String value) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (i == 0) {
                output.append(Character.toUpperCase(c));
            } else if (Character.isWhitespace(c)) {
                output.append(Character.toUpperCase(value.charAt(i + 1)));
                i++;
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    private static String combineVariable(String value) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);

            if (i == 0) {
                output.append(Character.toLowerCase(c));
            } else if (Character.isWhitespace(c)) {
                output.append(Character.toUpperCase(value.charAt(i + 1)));
                i++;
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    private static void runTests() {
        testSplitMethod();
        testSplitClass();
        testSplitVariable();
        testCombineMethod();
        testCombineClass();
        testCombineVariable();
    }

    private static void testSplitMethod() {
        System.out.println("Testing splitMethod:");
        System.out.println(splitMethod("getMethodName()")); // Expected: get method name
        System.out.println(splitMethod("setMethodName()")); // Expected: set method name
        System.out.println(splitMethod("processInput()")); // Expected: process input
        System.out.println();
    }

    private static void testSplitClass() {
        System.out.println("Testing splitClass:");
        System.out.println(splitClass("ClassName")); // Expected: class name
        System.out.println(splitClass("AnotherClassName")); // Expected: another class name
        System.out.println();
    }

    private static void testSplitVariable() {
        System.out.println("Testing splitVariable:");
        System.out.println(splitVariable("variableName")); // Expected: variable name
        System.out.println(splitVariable("anotherVariableName")); // Expected: another variable name
        System.out.println();
    }

    private static void testCombineMethod() {
        System.out.println("Testing combineMethod:");
        System.out.println(combineMethod("get method name")); // Expected: getMethodName()
        System.out.println(combineMethod("set method name")); // Expected: setMethodName()
        System.out.println(combineMethod("process input")); // Expected: processInput()
        System.out.println();
    }

    private static void testCombineClass() {
        System.out.println("Testing combineClass:");
        System.out.println(combineClass("class name")); // Expected: ClassName
        System.out.println(combineClass("another class name")); // Expected: AnotherClassName
        System.out.println();
    }

    private static void testCombineVariable() {
        System.out.println("Testing combineVariable:");
        System.out.println(combineVariable("variable name")); // Expected: variableName
        System.out.println(combineVariable("another variable name")); // Expected: anotherVariableName
        System.out.println();
    }
}