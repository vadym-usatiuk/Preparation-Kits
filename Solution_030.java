//Separate the Numbers
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
A numeric string, s, is beautiful if it can be split into a sequence of two or more positive integers,
a[1], a[2],..., a[n], satisfying the following conditions :
1. a[i]-ali-1] = 1 for any 1<i<n (i.e., each element in the sequence is 1 more than the previous element).
2. No a[i] contains a leading zero. For example, we can split 8 = 10203 into the sequence {1, 02, 03),
but it is not beautiful because 02 and 03 have leading zeroes. 3. The contents of the sequence cannot be rearranged.
For example, we can split s = 312 into the sequence (3, 1, 2),
but it is not beautiful because it breaks our first constraint (i.e., 1-3/1).
The diagram below depicts some beautiful strings : "1234" "1" + 2 + 3 + "91011" "9"+"10" 11" "99100" = "99" + "100"
Perform q queries where each query consists of some integer string 8. For each query,
print whether or not the string is beautiful on a new line. If it is beautiful, print YES x,
where is the first number of the increasing sequence. If there are multiple such values of x,
choose the smallest. Otherwise, print NO.
Function Description Complete the separateNumbers function in the editor below.
separateNumbers has the following parameter : • s : an integer value represented as a string Prints -string :
Print a string as described above. Return nothing.
Input Format The first line contains an integer q, the number of strings to evaluate.
Each of the next g lines contains an integer strings to query. Constraints • 1≤q≤ 10 • 1 ≤ 8 ≤ 32 • s[i] = [0-9]
*/
class Result_030 {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            long num = Long.parseLong(s.substring(0, i));
            long expected = num;
            int idx = i;
            boolean beautiful = true;
            while (idx < s.length()) {
                expected++;
                int len = String.valueOf(expected).length();
                if (idx + len > s.length() || Long.parseLong(s.substring(idx, idx + len)) != expected) {
                    beautiful = false;
                    break;
                }
                idx += len;
            }
            if (beautiful) {
                System.out.println("YES " + num);
                return;
            }
        }
        System.out.println("NO");
    }
}

public class Solution_030 {
    public static void main(String[] args) throws IOException {

        testSeparateNumbers();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                String s = bufferedReader.readLine();
//
//                Result_030.separateNumbers(s);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
    }


    public static void testSeparateNumbers() {
        // Test case 1
        System.out.println("Test case 1:");
        Result_030.separateNumbers("1234"); // Expected: YES 1

        // Test case 2
        System.out.println("Test case 2:");
        Result_030.separateNumbers("91011"); // Expected: YES 9

        // Test case 3
        System.out.println("Test case 3:");
        Result_030.separateNumbers("99100"); // Expected: YES 99

        // Test case 4
        System.out.println("Test case 4:");
        Result_030.separateNumbers("123"); // Expected: NO
    }
}
