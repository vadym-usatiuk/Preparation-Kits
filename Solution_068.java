//Sherlock and Anagrams
//~O(n^3 * log(m))

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
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
Example 8 = mom The list of all anagrammatic pairs is [m, m], [mo, om] at positions [[0], [2]], [[0,1], [1, 2]]
respectively. Function Description Complete the function sherlockAndAnagrams in the editor below.
sherlockAndAnagrams has the following parameter(s) :
⚫ string s : a string Returns
⚫int : the number of unordered anagrammatic pairs of substrings in s
Input Format The first line contains an integer g. the number of queries.
Each of the next lines contains a string & to analyze.
Constraints 1≤q≤10 2≤ length of s≤100 * contains only lowercase letters in the range ascii[a-z].
*/
class Result_068 {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                String sortedSubstring = new String(chars);

                map.put(sortedSubstring, map.getOrDefault(sortedSubstring, 0) + 1);
            }
        }

        for (int value : map.values()) {
            count += value * (value - 1) / 2; // combination formula is n * (n - 1) / 2
        }

        return count;
    }

}

public class Solution_068 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result_068.sherlockAndAnagrams(s);

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

