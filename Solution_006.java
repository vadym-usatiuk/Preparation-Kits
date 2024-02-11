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

class Result_006 {
/*
    Given an array of integers and a positive integer k,
    determine the number of (,) pairs where<j and ar[i]+arj is divisible by k.
    Example ar = [1, 2, 3, 4, 5, 6] k=5 Three pairs meet the criteria : [1,4], [2, 3], and [4, 6].
    Function Description Complete the divisibleSumPairs function in the editor below.
    divisibleSumPairs has the following parameter(s) : • int n : the length of array ar int ar[n] :
    an array of integers • int k : the integer divisor Returns -int :
    the number of pairs Input Format The first line contains 2 space-separated integers,
    ŉ and k. The second line contains space-separated integers, each a value of arr[i].
    Constraints • 2 ≤ n ≤ 100 . • 1≤k≤ 100 • 1 ≤ ar ≤ 100 Sample Input .
    Sample Output . STDIN . 63 . 132612
    Explanation Here are the 5 valid pairs when k= 3 : (0, 2)→ar [0] +ar[2] =1+2=3
    (0,5)→ar[0] +ar[5] =1+2=3 (1,3)→ar[1]+ar[3] =3+6=9 (2,4)→ar[2]+ar[4]=2+1=3
    (4,5)→ar[4]+ar[5] =1+2=3 Function n-6, k-3 ar [1, 3, 2, 6, 1, 2]
*/
    /*
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */


    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = ar.get(i) + ar.get(j);
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

public class Solution_006 {
    public static void main(String[] args) throws IOException {
        runLocalTests();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_006.divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void runLocalTests() {
        // Test case 1
        List<Integer> ar1 = Arrays.asList(1, 3, 2, 6, 1, 2);
        int n1 = ar1.size();
        int k1 = 3;
        int expected1 = 5;
        int result1 = Result_006.divisibleSumPairs(n1, k1, ar1);
        System.out.println("Test Case 1: " + (result1 == expected1 ? "Passed" : "Failed"));
    }
}
