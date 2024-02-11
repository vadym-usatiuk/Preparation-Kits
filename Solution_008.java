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


class Result_008 {

    /*
    1. Find the Median The median of a list of numbers is essentially its middle element after sorting.
    The same number of elements occur after it as before.
    Given a list of numbers with an odd number of elements,
    find the median? Example arr = [5, 3, 1, 2, 4] The sorted array arr
    ' = [1, 2, 3, 4, 5].
    The middle element and the median is 3.
    Function Description Complete the findMedian function in the editor below.
    findMedian has the following parameter(s) : int arr[n] :
    an unsorted array of integers Returns • int : the median of the array
    Input Format The first line contains the integer n, the size of arr.
    The second line contains n space-separated integers arr[i]
    Constraints • 1 ≤ n ≤ 1000001 • n is odd -10000 ≤ arr[i] ≤ 10000 Sample
    Input 0 7 0 1 2 4 6 53 Sample Output 0 3/*

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMedian(List<Integer> arr) {
        // Sort the array
        Collections.sort(arr);

        // Find the middle index
        int middleIndex = arr.size() / 2;

        // Return the middle element
        return arr.get(middleIndex);
    }

}

public class Solution_008 {
    public static void main(String[] args) throws IOException {
        testFindMedianOdd(); // local only
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_008.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static void testFindMedianOdd() {
        List<Integer> arr = Arrays.asList(7, 0, 1, 2, 4, 6, 53);
        int expected = 4; // Expected median is 4

        int result = Result_008.findMedian(arr);

        if (result == expected) {
            System.out.println("Test passed: findMedian for odd-sized array.");
        } else {
            System.out.println("Test failed: findMedian for odd-sized array.");
        }
    }
}

