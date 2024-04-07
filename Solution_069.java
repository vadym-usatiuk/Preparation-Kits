//Super Reduced String
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
Reduce a string of lowercase characters in range ascii['a'..'z']by doing a series of operations. In each operation, select a pair of adjacent letters that match, and delete them. Delete as many characters as possible using this method and return the resulting string. If the final string is empty, return Empty String Example. 8 = 'aab' aab shortens to b in one operation : remove the adjacent a characters. 8 = 'abba' Remove the two 'b' characters leaving 'aa'. Remove the two 'a' characters to leave". Return 'Empty String'. Function Description Complete the superReducedString function in the editor below. superReducedString has the following parameter(s) : ⚫ string s : a string to reduce Returns ⚫string : the reduced string or Empty String Input Format A single string, 8. Constraints 1 length of s 100
*/
class Result_69 {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.length() == 0 ? "Empty String" : sb.toString();
    }

}

public class Solution_069 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result_69.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

