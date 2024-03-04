//Mock Test 4 - Anagram
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
1. Anagram Two words are anagrams of one another if their letters can be rearranged to form the other word.
Given a string, split it into two contiguous substrings of equal length.
Determine the minimum number of characters to change to make the two substrings into anagrams of one another.
Example s = abccde Break s into two parts : 'abc' and 'cde'. Note that all letters have been used,
the substrings are contiguous and their lengths are equal.
Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have 'dec' and 'cde' which are anagrams.
Two changes were necessary. Function Description Complete the anagram function in the editor below.
anagram has the following parameter(s) : • string s : a string Returns • int :
the minimum number of characters to change or -1. Input Format The first line will contain an integer, q,
the number of test cases. Each test case will contain a string s. Constraints • 1 ≤ q ≤ 100 • 1 ≤|s| ≤ 104 .
s consists only of characters in the range ascii[a-z]. Sample Input 6 aaabbb ab abc mnop xyyx xaxbbbxx
Sample Output ONLF w 3 1 -1 2 1 Explanation Test Case #01 : We split 8 into two strings $1='aaa' and $2="bbb'.
 We have to replace all three characters from the first string with 'b' to make the strings anagrams.
 Test Case #02 : You have to replace 'a' with 'b', which will generate "bb". Test Case #03 :
 It is not possible for two strings of unequal length to be anagrams of one another. Test Case #04 :
 We have to replace both the characters of first string ("mn") to make it an anagram of the other one.
 Test Case #05 : S1 and S2 are already anagrams of one another. Test Case #06 : Here 51 = "xaxb" and 52 = "bbxx".
 You must replace 'a' from 51 with 'b' so that S1 = "xbxb".
*/

class Result_035 {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
        if (s.length() % 2 != 0) return -1;

        int changes = 0;
        int mid = s.length() / 2;
        Map<Character, Integer> counts = new HashMap<>();

        // Count occurrences of characters in the first half
        for (int i = 0; i < mid; i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // Count occurrences of characters in the second half
        for (int i = mid; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                // Character not found or already matched, need to change
                changes++;
            } else {
                // Decrement the count of matched character
                counts.put(c, counts.get(c) - 1);
            }
        }

        return changes;
    }
}

public class Solution_035 {
    public static void main(String[] args) throws IOException {
        // Test cases
        runTest("aaabbb", 3);
        runTest("ab", 1);
        runTest("abc", -1);
        runTest("mnop", 2);
        runTest("xyyx", 0);
        runTest("xaxbbbxx", 1);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                String s = bufferedReader.readLine();
//
//                int result = Result_035.anagram(s);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    private static void runTest(String s, int expected) {
        int result = Result_035.anagram(s);
        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);
        System.out.println("Test Result: " + (result == expected ? "Passed" : "Failed"));
        System.out.println("--------------------------------------");
    }
}

