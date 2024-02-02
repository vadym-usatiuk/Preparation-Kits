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

class Result_002 {

//    Given five positive integers, find the minimum and maximum values that can be calculated by
//    summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line
//    of two space-separated long integers. Example arr = [1,3,5,7,9] The minimum sum is 1+3+5+7=16 and
//    the maximum sum is 3+5+7+9= 24. The function prints 16 24 Function Description
//    Complete the miniMaxSum function in the editor below.
//    miniMaxSum has the following parameter(s) : • arr : an array of 5 integers
//    Print Print two space-separated integers on one line : the minimum sum and the maximum sum of 4 of 5 elements.
//    Input Format A single line of five space-separated integers. Constraints 1 ≤ arri] ≤ 10°
//    Output Format Print two space-separated long integers denoting the respective minimum and
//    maximum values that can be calculated by summing exactly four of the five integers.
//    (The output can be greater than a 32 bit integer.) Sample Input 12345 Sample Output 10 14 Explanation
//    The numbers are 1, 2, 3, 4, and 5. Calculate the following sums using four of the five integers :
//    1. Sum everything except 1. the sum is 2+3+4+5=14 2. Sum everything except 2, the sum is 1+3+4+5=13.
//    3. Sum everything except 3. the sum is 1+2+4+5=12 4. Sum everything except 4, the sum is 1+2+3+5=11.
//    5. Sum everything except 5. the sum is 1+2+3+4=10. Hints : Beware of integer overflow! Use 64-bit Integer.

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long minSum = Long.MAX_VALUE; // Initialize minSum to a very large value
        long maxSum = Long.MIN_VALUE; // Initialize maxSum to a very small value
        long totalSum = 0;

        // Calculate the total sum of all five integers
        for (int num : arr) {
            totalSum += num;
        }

        // Find the min and max sums by excluding each integer one by one
        for (int num : arr) {
            long sumWithoutNum = totalSum - num;
            minSum = Math.min(minSum, sumWithoutNum);
            maxSum = Math.max(maxSum, sumWithoutNum);
        }

        // Print the min and max sums like space-separated long integers
        System.out.println(minSum + " " + maxSum);
    }
}

public class Solution_002 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        Result_002.miniMaxSum(arr);
//
//        bufferedReader.close();

        // Test cases
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Test case 1:");
        Result_002.miniMaxSum(test1); // Expected output: "10 14"

        List<Integer> test2 = Arrays.asList(7, 3, 1, 9, 12);
        System.out.println("Test case 2:");
        Result_002.miniMaxSum(test2); // Expected output: "20 31"
    }
}

