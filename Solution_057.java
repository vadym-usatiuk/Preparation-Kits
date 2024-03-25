//Sherlock and the Valid String
//O(n) + O(n) + O(n) = O(n)

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
Sherlock considers a string to be valid if all characters of the string appear the same number of times.
It is also valid if he can remove just 1 character at 1 index in the string,
and the remaining characters will occur the same number of times.
Given a string s. determine if it is valid. If so, return YES, otherwise return NO.
Example s=abc This is a valid string because frequencies are (a : 1,6 : 1,e : 1}. s=abcc
This is a valid string because we can remove one cand have 1 of each character in the remaining string. s = abccc
This string is not valid as we can only remove 1 occurrence of <.
That leaves character frequencies of {a : 1, b : 1, c : 2}.
Function Description Complete the isValid function in the editor below. isValid has the following parameter(s) :
 ⚫strings : a string Returns
 ⚫string either YES or NO Input Format A single string & Constraints
 ⚫1≤10 Each character s[i] € asciila-z]
 Sample Input
 aabbcd
 Sample Output
 Explanation 2 is the minimum number of removals required to make it a valid string.
 It can be done in following two ways : Remove c and d to get aabb. Or remove a and b to get abcd.
*/

class Result_057 {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqOfFreqMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            freqOfFreqMap.put(freq, freqOfFreqMap.getOrDefault(freq, 0) + 1);
        }

        if (freqOfFreqMap.size() == 1) {
            return "YES";
        } else if (freqOfFreqMap.size() == 2) {
            int f1 = (int) freqOfFreqMap.keySet().toArray()[0];
            int f2 = (int) freqOfFreqMap.keySet().toArray()[1];

            if ((freqOfFreqMap.get(f1) == 1 && (f1 - 1 == f2 || f1 == 1)) ||
                    (freqOfFreqMap.get(f2) == 1 && (f2 - 1 == f1 || f2 == 1))) {
                return "YES";
            }
        }
        return "NO";
    }

}

public class Solution_057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result_057.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

