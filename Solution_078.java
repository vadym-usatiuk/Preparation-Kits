//The Maximum Subarray
//o(n)

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
We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array. Given an array, find the maximum possible sum among : 1. all nonempty subarrays. 2. all nonempty subsequences. Print the two values as space-separated integers on one line. Note that empty subarrays/subsequences should not be considered. Example arr-[-1,2,3,-4,5,10] The maximum subarray sum is comprised of elements at inidices [1-5]. Their sum is 2+3+-4+5+10=16. The maximum subsequence sum is comprised of elements at indices [1,2,4,5] and their sum is 2+3+5+10=20. Function Description Complete the maxSubarray function in the editor below. maxSubarray has the following parameter(s) : int arr[n] : an array of integers Returns • int[2] : the maximum subarray and subsequence sums Input Format The first line of input contains a single integer f. the number of test cases. The first line of each test case contains a single integer n. The second line contains space-separated integers arr[i] where << Constraints 1st≤ 10 ⚫ 1≤ n ≤105 ⚫ -10° arr[]≤10* The subarray and subsequences you consider should have at least one element. Sample Input 1234 NATAN 2 4 6 2-1234-5 Sample Output 10 10 10 11 Explanation In the first case : The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive). In the second case : [2-1 2 3 4]--> This forms the contiguous sub-array with the maximum sum. For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
*/

class Result_078 {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        int current = 0;
        for (int i : arr) {
            sum += Math.max(0, i);
            current = Math.max(i, current + i);
            answer = Math.max(answer, current);
        }
        return Arrays.asList(answer, answer < 0 ? answer : sum);
    }

}

public class Solution_078 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result_078.maxSubarray(arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

