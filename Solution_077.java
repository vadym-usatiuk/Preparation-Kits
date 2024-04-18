//Two Characters
//O(n^2)

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
Given a string, remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Determine the longest string possible that contains just two alternating letters. Example s = 'abaacdabd' Delete a, to leave bcdbd. Now, remove the character c to leave the valid string bdbd with a length of 4. Removing either bord at any point would not result in a valid string. Return 4. Given a string, convert it to the longest possible string made up only of alternating characters. Return the length of string. If no string can be formed, return. Function Description Complete the alternate function in the editor below. alternate has the following parameter(s) : strings : a string Returns. ⚫int : the length of the longest valid string, or if there are none Input Format The first line contains a single integer that denotes the length of a. The second line contains string. Constraints 15 length of s 1000 ⚫s[6] € asciila-z] Sample Input STDIN Function 10 length of s - 10 beabeefeab s 'beabeefeab' Sample Output Explanation The characters present in a are a, b. e. and f. This means that must consist of two of those characters and we must delete two others. Our choices for characters to leave are [a,b], [ael, la, fl. it. el. ib. f) and If we delete e and f, the resulting string is babab. This is a valid as there are only two distinct characters (a and b), and they are alternating within the string. If we delete a and f, the resulting string is bebeeeb. This is not a valid string because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string. Other cases are solved similarly. babab is the longest string we can create.
*/

class Result_077 {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        if (s.length() == 1) {
            return 0;
        }

        int maxAlternateLength = 0;

        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = (char) (c1 + 1); c2 <= 'z'; c2++) {
                int alternateLength = 0;
                char prev = '\0';
                boolean isValid = true;

                for (char ch : s.toCharArray()) {
                    if (ch == c1 || ch == c2) {
                        if (ch == prev) {
                            isValid = false;
                            break;
                        }
                        alternateLength++;
                        prev = ch;
                    }
                }

                if (isValid) {
                    maxAlternateLength = Math.max(maxAlternateLength, alternateLength);
                }
            }
        }

        return maxAlternateLength;
    }
}

public class Solution_077 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result_077.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

