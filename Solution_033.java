//Minimum Absolute Difference in an Array
//O(n log n)

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
The absolute difference is the positive difference between two values a and b.
is written a - b or lb-al and they are equal. If a = 3 and b = 2.13-2| = |23|= 1.
Given an array of integers, find the minimum absolute difference between any two elements in the array.
Example. arr = [-2,2,4] There are 3 pairs of numbers : [-2, 2], [-2, 4] and [2, 4].
The absolute differences for these pairs are |(-2) - 2| = 4. |(-2) -4 = 6 and 2-4 = 2.
The minimum absolute difference is 2. Function Description Complete the minimumAbsolute
Difference function in the editor below.
It should return an integer that represents the minimum absolute difference between any pair of elements.
minimumAbsolute Difference has the following parameter(s) : • int arr[n] : an array of integers Returns int :
the minimum absolute difference found Input Format The first line contains a single integer n. the size of arr.
The second line contains n space-separated integers, arr[i]. Constraints • 2 ≤ n ≤ 105 -10° ≤ arr[i] ≤ 10⁹
*/
class Result_033 {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        Collections.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int diff = Math.abs(arr.get(i) - arr.get(i - 1));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

}

public class Solution_033 {
    public static void main(String[] args) throws IOException {
        List<Integer> arr1 = Arrays.asList(-2, 2, 4);
        System.out.println(Result_033.minimumAbsoluteDifference(arr1)); // Expected output: 2

        List<Integer> arr2 = Arrays.asList(1, 3, 5, 7);
        System.out.println(Result_033.minimumAbsoluteDifference(arr2)); // Expected output: 2

        List<Integer> arr3 = Arrays.asList(1, 3, 1, 7);
        System.out.println(Result_033.minimumAbsoluteDifference(arr3)); // Expected output: 0

        List<Integer> arr4 = Arrays.asList(1, 3, 6, 10);
        System.out.println(Result_033.minimumAbsoluteDifference(arr4)); // Expected output: 2
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result_033.minimumAbsoluteDifference(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
