//Closest Numbers
//O(n log n)

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
Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier,
but there are other uses as well. In this case, it will make it easier to determine which pair or pairs of elements
have the smallest absolute difference between them. Example arr = 5,2,3,4,1 Sorted, arr = [1, 2, 3, 4, 5].
Several pairs have the minimum difference of 1 : [(1, 2), (2,3), (3, 4), (4, 5).
Return the array [1, 2, 2, 3, 3, 4, 4, 5]. Note As shown in the example, pairs may overlap.
Given a list of unsorted Integers, arr, find the pair of elements that have the smallest absolute difference
between them. If there are multiple pairs, find them all Function Description Complete the closest Numbers function
in the editor below. closestNumbers has the following parameter(s) int arrint an array of integers Returns -Int[] :
an array of integers as described Input Format The first line contains a single integer n, the length of arr.
The second line contains n space-separated integers, arr Constraints 25200000 • -10¹ ≤ arr[i] ≤ 10¹ . All a[] are
unique in arr.
Output Format Sample Input 0 18 -28-3916237 -357920 -3620681 7374819 -7338761 38 6246457 -6461594 266854
Sample Output 0 -28 30 Explanation 0 (30)-(-20) = 50, which is the smallest difference.
Sample Input 1 12 -28 -3916237 -357920 -3620681 7374819 -7338761 38 6246457 -6461594 266854 -528 -478
Sample Output 1 -528-476-26 30 Explanation 1 (-470)-(-520) = 30-(-20) 50, which is the smallest difference.
Sample Input 2 5432 Sample Output 2 233445 Explanation 2 Here, the minimum difference is 1.
Valid pairs are (2, 3), (3, 4), and (4, 5).
*/
class Result_031 {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Sort the array
        Collections.sort(arr);

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = arr.get(i + 1) - arr.get(i);
            minDiff = Math.min(minDiff, diff);
        }

        // Find pairs with minimum difference
        List<Integer> pairs = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = arr.get(i + 1) - arr.get(i);
            if (diff == minDiff) {
                pairs.add(arr.get(i));
                pairs.add(arr.get(i + 1));
            }
        }

        return pairs;
    }

}

public class Solution_031 {
    public static void main(String[] args) throws IOException {

        // Test cases
        List<List<Integer>> testCases = new ArrayList<>();
        testCases.add(Arrays.asList(5, 2, 3, 4, 1));
        testCases.add(Arrays.asList(12, -28, -3916237, -357920, -3620681, 7374819, -7338761, 38, 6246457, -6461594, 266854, -528, -478));
        testCases.add(Arrays.asList(5, 4, 3, 2, 1));

        // Execute test cases
        for (List<Integer> testCase : testCases) {
            List<Integer> result = Result_031.closestNumbers(testCase);
            System.out.println("Closest numbers: " + result);
        }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result_031.closestNumbers(arr);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
