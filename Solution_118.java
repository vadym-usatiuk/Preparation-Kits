//Short Palindrome
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
    Consider a string. s. of n lowercase English letters where each character. s, (0 <i<n). denotes the letter at index i in s. We define an (a, b, c, d) palindromic tuple of s to be a sequence of indices in s satisfying the following criteria : • S₁ = s. meaning the characters located at indices a and d are the same. ⚫st, sc. meaning the characters located at indices b and c are the same. • 0≤a<b<c<d<|s, meaning that a. b. c. and d are ascending in value and are valid indices within string s. Given s, find and print the number of (a, b, c, d) tuples satisfying the above conditions. As this value can be quite large, print it modulo (109 +7). Function Description Complete the function shortPalindrome in the editor below. shortPalindrome has the following paramter(s) : - string s : a string Returns -int : the number of tuples, modulo (109 +7) Input Format A single string. s. Constraints ⚫ 1≤s ≤106 • It is guaranteed that s only contains lowercase English letters.
    Sample Input O kkkkkkz Sample Output 0 15 Explanation O The letter z will not be part of a valid tuple because you need at least two of the same character to satisfy the conditions defined above. Because all tuples consisting of four k's are valid, we just need to find the number of ways that we can choose four of the six k's. This means our answer is (9) mod (109 +7)= 15. Sample Input 1 ghhggh Sample Output 1 Explanation 1 The valid tuples are : 1. (0,1,2,3) 2. (0,1,2,4) 3. (1,3,4,5) 4. (2,3,4,5) Thus, our answer is 4 mod (109 +7)= 4.
    */

public class Solution_118 {
    class Result {

        /*
         * Complete the 'shortPalindrome' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int shortPalindrome(String s) {
            int MOD = 1_000_000_007;
            int n = s.length();

            long[] singleCount = new long[26];
            long[][] pairCount = new long[26][26];
            long[] tripletCount = new long[26];

            long palindromeCount = 0;

            for (char ch : s.toCharArray()) {
                int charIndex = ch - 'a';

                palindromeCount = (palindromeCount + tripletCount[charIndex]) % MOD;

                for (int i = 0; i < 26; i++) {
                    tripletCount[i] = (tripletCount[i] + pairCount[i][charIndex]) % MOD;
                }

                for (int i = 0; i < 26; i++) {
                    pairCount[i][charIndex] = (pairCount[i][charIndex] + singleCount[i]) % MOD;
                }

                singleCount[charIndex] = (singleCount[charIndex] + 1) % MOD;
            }

            return (int) palindromeCount;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = bufferedReader.readLine();

            int result = Result.shortPalindrome(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
