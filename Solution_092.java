//Common Child
// O(nm)

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
A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Letters cannot be rearranged. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both? Example s1='ABCD s2= 'ABDC These strings have two children with maximum length 3. ABC and ABD. They can be formed by eliminating either the D or C from both strings. Return 3. Function Description Complete the commonChild function in the editor below. commonChild has the following parameter(s) : ⚫ string s1 : a string ⚫ string $2 : another string Returns • int : the length of the longest string which is a common child of the input strings Input Format There are two lines, each with a string. $1 and $2. Constraints ⚫ 1≤|s1|, |s2|≤ 5000 where s❘ means "the length of 8" • All characters are upper case in the range ascii[A-Z]. Sample Input HARRY SALLY Sample Output 2.
Explanation The longest string that can be formed by deleting zero or more characters from HARRY and SALLY is AY, whose length is 2. Sample Input 1 AA BB Sample Output 1 Explanation 1 AA and BB have no characters in common and hence the output is O. Sample Input 2 SHINCHAN NOHARAAA Sample Output 2 3 Explanation 2 The longest string that can be formed between SHINCHAN and NOHARAAA while maintaining the order is NHA. Sample Input 3 ABCDEF FBDAMN Sample Output 3 2 Explanation 3 BD is the longest child of the given strings.
*/

class Result_092 {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) { //1
            for (int j = 0; j < m; j++) { //2
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n][m];
    }
}

public class Solution_092 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result_092.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

