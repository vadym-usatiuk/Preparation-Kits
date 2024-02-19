//Pangrams
//Time complexity is O(n)
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
A pangram is a string that contains every letter of the alphabet.
Given a sentence determine whether it is a pangram in the English alphabet.
Ignore case. Return either pangram or not pangram as appropriate.
Example 8 = 'The quick brown fox jumps over the lazy dog' The string contains all letters in the English alphabet,
so return pangram. Function Description Complete the function pangrams in the editor below.
It should return the string pangram if the input string is a pangram. Otherwise,
it should return not pangram. pangrams has the following parameter(s) : • string s : a string to test
Returns • string : either pangram or not pangram Input Format A single line with string 8.
Constraints 0 < length of s < 10³ Each character of 8, s[i] = {a-z, A-Z, space}
Sample Input Sample Input 0 We promptly judged antique ivory buckles for the next prize
Sample Output 0 pangram Sample Explanation 0 All of the letters of the alphabet are present in the string.
Sample Input 1 We promptly judged antique ivory buckles for the prize Sample Output 1 not pangram
Sample Explanation 0 The string lacks an x.
*/
class Result_015 {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                set.add(ch);
            }
        }
        return set.size() == 26 ? "pangram" : "not pangram";
    }

    // Local test method
    public static void localTest() {
        // Test cases
        String[] testCases = {
                "We promptly judged antique ivory buckles for the next prize", //is pangram
                "We promptly judged antique ivory buckles for the prize",     // is not pangram
        };

        for (String testCase : testCases) {
            System.out.println(testCase);
            System.out.println("Result: " + pangrams(testCase));
            System.out.println();
        }
    }
}

public class Solution_015 {
    public static void main(String[] args) throws IOException {
        //local test
        Result_015.localTest();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String result = Result_015.pangrams(s);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
