//Strong Password
//O(n)

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
Louise joined a social networking site to stay in touch with her friends.
The signup page required her to input a name and a password. However, the password must be strong.
The website considers a password to be strong if it satisfies the following criteria :
• Its length is at least 6.
• It contains at least one digit. • It contains at least one lowercase English character.
• It contains at least one uppercase English character.
• It contains at least one special character.
The special characters are : !@#$%^&* ()-+ She typed a random string of length in the password field
but wasn't sure if it was strong. Given the string she typed, can you find the minimum number of characters
she must add to make her password strong? Note : Here's the set of types of characters in a form you can paste
in your solution : numbers "0123456789" lower case "abcdefghijklmnopqrstuvwxyz" upper case "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special characters = "!@#$%^&* ()+"
Example password='2bbbb' This password is 5 characters long and is missing an uppercase and a special character.
The minimum number of characters to add is 2. password='2bb#A'
This password is 5 characters long and has at least one of each character type.
The minimum number of characters to add is 1.
Function Description Complete the minimumNumber function in the editor below.
minimumNumber has the following parameters : int n : the length of the password • string password :
the password to test Returns int : the minimum number of characters to add
Input Format The first line contains an integer 7, the length of the password.
The second line contains the password string. Each character is either a lowercase/uppercase English alphabet,
a digit, or a special character.
Constraints • 1 ≤ n ≤ 100 • All characters in password are in [a-z], [A-Z], [0-9], or [l@#$%^&*( ) -+ ].
*/
class Result_037 {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        Set<Character> specialCharacters = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

        boolean hasDigit = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasSpecialCharacter = false;

        int additionsNeeded = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            else if (Character.isLowerCase(c)) hasLowercase = true;
            else if (Character.isUpperCase(c)) hasUppercase = true;
            else if (specialCharacters.contains(c)) hasSpecialCharacter = true;
        }

        if (!hasDigit) additionsNeeded++;
        if (!hasLowercase) additionsNeeded++;
        if (!hasUppercase) additionsNeeded++;
        if (!hasSpecialCharacter) additionsNeeded++;

        return Math.max(additionsNeeded, 6 - n);
    }
}

public class Solution_037 {
    public static void main(String[] args) throws IOException {
        testMinimumNumber(4, "abcd", 3); // Expected output: 3
        testMinimumNumber(6, "abcdef", 1); // Expected output: 1
        testMinimumNumber(8, "123ABC", 1); // Expected output: 1
        testMinimumNumber(6, "abc123", 0); // Expected output: 0
        testMinimumNumber(5, "Ab@12", 1); // Expected output: 1
        testMinimumNumber(7, "Password123@", 0); // Expected output: 0
        
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String password = bufferedReader.readLine();
//
//        int answer = Result_037.minimumNumber(n, password);
//
//        bufferedWriter.write(String.valueOf(answer));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    private static void testMinimumNumber(int n, String password, int expected) {
        int result = Result_037.minimumNumber(n, password);
        System.out.println("Password: " + password + ", Expected: " + expected + ", Result: " + result);
        assert result == expected : "Test failed";
    }
}

