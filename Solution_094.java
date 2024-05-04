//Highest Value Palindrome
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
Palindromes are strings that read the same from the left or right, for example madam or 0110. You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 0's left of all higher digits in your tests. For example 0110 is valid, 0011 is not. Given a string representing the starting number, and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string '-1' if it is not possible to create a palindrome under the contstraints. Example 8 = '1231' k = 3 Make 3 replacements to get '9339'. 8 = '12321' k=1 Make 1 replacement to get '12921'. Function Description Complete the highestValuePalindrome function in the editor below. highest ValuePalindrome has the following parameter(s) : • string s : a string representation of an integer ⚫ int n : the length of the integer string ⚫ int k : the maximum number of changes allowed Returns ⚫ string : a string representation of the highest value achievable or -1 Input Format The first line contains two space-separated integers, and k, the number of digits in the number and the maximum number of changes allowed. The second line contains an 12-digit string of numbers. Constraints • 0<n≤10³ 0 ≤ k ≤ 10³ • Each character i in the number is an integer where 0 ≤i≤9.
Output Format Sample Input O STDIN Function 41 n = 4, k = 1 3943 s = '3943' Sample Output 0 3993 Sample Input 1 63 092282 Sample Output 1 992299 Sample Input 2 41 0011 Sample Output 2 Explanation Sample O There are two ways to make 3943 a palindrome by changing no more than k = 1 digits : 1.39433443 2.3943 → 3993 39933443
*/

class Result_094 {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder sb = new StringBuilder(s);
        Set<Integer> in = new HashSet<>();


        if (s.length() == 1) {
            return "9";
        }

        int total = n % 2 == 0 ? n / 2 : n / 2 + 1;

        for (int i = 0; i < total; i++) {
            if (sb.charAt(i) != sb.charAt(n - 1 - i)) {
                if (k > 0) {
                    if (sb.charAt(i) > sb.charAt(n - 1 - i)) {
                        sb.setCharAt(n - 1 - i, sb.charAt(i));
                    } else {
                        sb.setCharAt(i, sb.charAt(n - 1 - i));
                    }
                    in.add(i);
                } else {
                    return "-1";
                }
                k--;
            }
        }

        System.out.println("After Validation: " + k + " val: " + sb.toString());
        int j = 0;
        while (k > 0 && j < total) {

            if (sb.charAt(j) == '9') {
                j++;
                continue;
            }
            if (in.contains(j)) {
                sb.setCharAt(n - 1 - j, '9');
                sb.setCharAt(j, '9');
                k--;
            } else {
                if (k == 1) {
                    j++;
                    continue;
                }
                sb.setCharAt(n - 1 - j, '9');
                sb.setCharAt(j, '9');
                k -= 2;
            }
            j++;
        }

        if (k > 0 && n % 2 != 0) {
            sb.setCharAt(n / 2, '9');
        }
        return sb.toString();
    }
}

public class Solution_094 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result_094.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

