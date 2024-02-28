//Mock Test 3 - Between Two Sets
//O((minB - maxA + 1) * (m + n)) or O((m + n) * (minB - maxA))

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
1. Between Two Sets There will be two arrays of integers.
Determine all integers that satisfy the following two conditions :
1. The elements of the first array are all factors of the integer being considered
2. The integer being considered is a factor of all elements of the second array
These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
Example a = (2,6) b= [24,36]
There are two numbers between the arrays : 6 and 12. 6%2=0,6%6= 0,24%6= 0 and
36%6= 0 for the first value. 12% 2 = 0, 12% 6 = 0 and 24% 12 = 0,36% 12 = 0 for the second value.
Return 2. Function Description Complete the getTotalX function in the editor below.
It should return the number of integers that are betwen the sets. getTotalx has the following parameter(s) :
• int a[n] an array of integers • int b[m] : an array of integers Returns • int :
the number of integers that are between the sets Input Format The first line contains two space-separated integers,
12 and 17, the number of elements in arrays a and b.
The second line contains 12 distinct space-separated integers a[i] where 0 <i<n.
The third line contains m distinct space-separated integers b[j] where 0 ≤ j<m.
Constraints • 1≤n, m≤ 10 • 1 ≤ a[i] ≤ 100 • 1 ≤bj] ≤ 100 Sample Input 23 24 16 32 96
Sample Output 3 Explanation 2 and 4 divide evenly into 4, 8, 12 and 16. 4,8 and 16 divide evenly into
16, 32, 96. 4,8 and 16 are the only three numbers for which each element of a is a factor and each is a factor
of all elements of b.
*/
class Result_026 {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int count = 0;
        int maxA = a.stream().mapToInt(Integer::intValue).max().getAsInt();
        int minB = b.stream().mapToInt(Integer::intValue).min().getAsInt();

        for (int num = maxA; num <= minB; num++) {
            if (isFactorOfArrayB(num, b) && isDivisibleByArrayA(num, a)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isFactorOfArrayB(int num, List<Integer> b) {
        for (int x : b) {
            if (x % num != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDivisibleByArrayA(int num, List<Integer> a) {
        for (int x : a) {
            if (num % x != 0) {
                return false;
            }
        }
        return true;
    }
}


public class Solution_026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result_026.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
