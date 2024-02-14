//Flipping bits
// O(1)

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

class Result_011 {

    /*
    You will be given a list of 32 bit unsigned integers.
    Flip all the bits (10 and 0-1) and return the result as an unsigned integer.
    Example 72=910 910 = 10012. We're working with 32 bits, so :
    000000000000000000000000000010012=910 11111111111111111111111111110110₂ = 429496728610 Return 4294967286.
    Function Description Complete the flippingBits function in the editor below.
    flippingBits has the following parameter(s) : • int n an integer Returns • int :
    the unsigned decimal integer result Input Format The first line of the input contains g,
    the number of queries. Each of the next 4 lines contain an integer, #, to process.
    Constraints 1≤q≤ 100 0<n<2%2 Sample Input 3 2147483647 1 0
    Sample Output 2147483648 4294967294 4294967295 Explanation Take 1 for example,
    as unsigned 32-bits is 0000 00000001 and doing the flipping we get 1111111111 111111111110
    which in turn is 4294967294.
    */
    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        // Write your code here
        return n ^ ((1L << 32) - 1);
    }

}

public class Solution_011 {
    public static void main(String[] args) throws IOException {

        localTest();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                long n = Long.parseLong(bufferedReader.readLine().trim());
//
//                long result = Result_011.flippingBits(n);
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

    // Method for local testing
    public static void localTest() {
        long[] testCases = {2147483647, 1, 0};

        System.out.println("Test Results:");
        for (long testCase : testCases) {
            long result = Result_011.flippingBits(testCase);
            System.out.println("Input: " + testCase + ", Output: " + result);
        }
    }
}
