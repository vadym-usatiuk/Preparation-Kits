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

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    //    Given an array of integers, calculate the ratios of its elements that are positive,
    //    negative, and zero. Print the decimal value of each fraction on a new line with 6 places after the decimal.
    //    -4 Note : This challenge introduces precision problems. The test cases are scaled to six decimal places,
    //    though answers with absolute error of up to 10 are acceptable. Example arr = [1,1,0,-1,-1]
    //    There are 7 = 5 elements, two positive, two negative and one zero.
    //    Their ratios are = 0.400000.2=0.400000 and =0.200000.
    //    Results are printed as : 0.400000 0.400000 0.200000
    //    Function Description Complete the plusMinus function in the editor below.
    //    plusMinus has the following parameter(s) : int arr[n] : an array of integers Print the ratios of positive,
    //    negative and zero values in the array. Each value should be printed on a separate line with 6 digits
    //    after the decimal. The function should not return a value.
    //    Input Format The first line contains an integer, n. the size of the array.
    //    The second line contains space-separated integers that describe arr[n].
    //    Constraints 0 < n ≤ 100 -100 ≤ arr[i] ≤ 100 Output Format . Print the following 3 lines,
    //    each to 6 decimals : 1. proportion of positive values 2. proportion of negative values 3.
    //    proportion of zeros Sample Input STDIN 6 -4 3-9 0 4 1 Sample Output 0.500000 0.333333 0.166667
    //    Function arr[] size n-6 arr [-4, 3, 9, 0, 4, 1] Explanation There are 3 positive numbers, 2 negative numbers,
    //    and 1 zero in the array. The proportions of occurrence are positive : =0.500000, negative : = 0.333333
    //    and zeros : = 0.166667.

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // Calculate the proportions
        double positiveRatio = (double) positiveCount / n;
        double negativeRatio = (double) negativeCount / n;
        double zeroRatio = (double) zeroCount / n;

        // Print
        System.out.println(positiveRatio);
        System.out.println(negativeRatio);
        System.out.println(zeroRatio);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
//
//        Result.plusMinus(arr);
//
//        bufferedReader.close();

        // Test the plusMinus function in local environment
        List<Integer> sampleList = Arrays.asList(-4, 3, -9, 0, 4, 1);
        System.out.println("Testing plusMinus with sampleList:");
        Result.plusMinus(sampleList);
    }
}
