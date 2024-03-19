//Mock Test 6 - Palindrome Index
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
1. Palindrome Index Given a string of lowercase letters in the range ascii[a-z],
determine the index of a character that can be removed to make the string a palindrome.
There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution,
return -1. Otherwise, return the index of a character to remove.
Example s="bcbc" Either remove 'b'at index 0 or 'c'at index 3.
Function Description Complete the palindromelndex function in the editor below.
palindromeindex has the following parameter(s) : strings : a string to analyze Returns int :
the index of the character to remove or -1 Input Format The first line contains an integer q,
the number of queries. Each of the next q lines contains a query string s. Constraints
159≤20 1 length of s≤105 +5 • All characters are in the range ascii[a-z].
Sample Input STDIN Function 3 9-3 aaab baa s='aaab' (first query) s='baa' (second query) ааа s'aaa' (third query)
Sample Output Explanation
Query 1 : "aaab" Removing 'b'at index 3 results in a palindrome, so return 3.
Query 2 : "baa" Removing 'b'at index 0 results in a palindrome, so return 0.
Query 3 : "aaa" This string is already a palindrome, so return -1.
Removing any one of the characters would result in a palindrome, but this test comes first.
Note : The custom checker logic for this challenge is available here.
*/

class Result_053 {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // check if removing the left character makes it a palindrome
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                // check if removing the right character makes it a palindrome
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                return -1; // If neither, then it's not possible by removing just one character
            }
            left++;
            right--;
        }

        // the string is already a palindrome
        return -1;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution_053 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result_053.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
