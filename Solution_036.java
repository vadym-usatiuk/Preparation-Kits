//Max Min
//O(n log n)

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
You will be given a list of integers, are, and a single integer &.
You must create an array of length & from elements of arr such that its unfairness is minimized.
Call that array arr. Unfairness of an array is calculated as maz(arr')-min(arr') Where :
 max denotes the largest integer in arr. min denotes the smallest integer in arr'.
 Example arr = [1,4,7,2 k=2 Pick any two elements, say arr' = [4, 7 unfairness = maz(4,7)- min(4,7)=7-4=3
 Testing for all pairs, the solution [1, 2] provides the minimum unfairness.
 Note : Integers in arr may not be unique. Function Description Complete the maxMin function in the editor below.
 maxMin has the following parameter(s) int ic the number of elements to select int arrin an array of integers Returns .
 int : the minimum possible unfalmess Input Format The first line contains an Integer ,
 the number of elements in array arr. The second line contains an integer k Each of the next lines
 contains an integer arr[] where 0 si<n Constraints 2≤x≤ 10¹ 2≤ksn 0 ≤ arri] ≤ 10⁹
 Sample Input Sample Input 201 UN-5 18 28 38 48 188 280
 Sample Output Sample Output #01 Explanation Explanation #01 Here K = 4 : selecting the 4
 integers 1, 2, 3, 4, unfairness equals max(1,2,3,4) - min(1,2,3,4)-4-1-3
*/
class Result_036 {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int minUnfairness = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size() - k; i++) {
            int unfairness = arr.get(i + k - 1) - arr.get(i);
            if (unfairness < minUnfairness) {
                minUnfairness = unfairness;
            }
        }
        return minUnfairness;
    }
}

public class Solution_036 {
    public static void main(String[] args) throws IOException {
        runTest(new int[]{1, 4, 7, 2}, 2, 1);
        runTest(new int[]{10, 100, 300, 200, 1000, 20, 30}, 3, 20);
        runTest(new int[]{1, 2, 1, 2, 1}, 2, 0);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result_036.maxMin(k, arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    private static void runTest(int[] arr, int k, int expected) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        int result = Result_036.maxMin(k, list);
        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("K: " + k);
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);
        System.out.println("Test Result: " + (result == expected ? "Passed" : "Failed"));
        System.out.println("--------------------------------------");
    }
}

