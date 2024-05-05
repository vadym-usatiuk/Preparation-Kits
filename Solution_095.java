//Lily's Homework
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
Whenever George asks Lily to hang out, she's busy doing homework. George wants to help her finish it faster, but he's in over his head! Can you help George understand Lily's homework so she can hang out with him? Consider an array of distinct integers, arr = [a0, a1,...,an - 1]]. George can swap any two elements of the array any number of times. An array is beautiful if the sum of arr[i] - arr[i - 1]| among 0 < i < n is minimal. Given the array arr. determine and return the minimum number of swaps that should be performed in order to make the array beautiful. Example arr = [7, 15, 12, 3] One minimal array is [3, 7, 12, 15]. To get there, George performed the following swaps : Swap 37 Result [7, 15, 12, 3] [3, 15, 12, 7] 7 15 [3, 7, 12, 15] It took 2 swaps to make the array beautiful. This is minimal among the choices of beautiful arrays possible. Function Description Complete the lilysHomework function in the editor below. lilysHomework has the following parameter(s) : ⚫ int arr[n] : an integer array Returns ⚫int : the minimum number of swaps required Input Format The first line contains a single integer, n, the number of elements in arr. The second line contains n space-separated integers, arr[i]. Constraints ⚫ 1≤ n ≤105 • 1≤ arr[i] ≤2 × 10° Sample Input STDIN Function 4 2531 arr[]size n = 4 arr = [2, 5, 3, 1]
Sample Output 2 Explanation Define arr' = [1,2,3,5] to be the beautiful reordering of arr. The sum of the absolute values of differences between its adjacent elements is minimal among all permutations and only two swaps (1 with 2 and then 2 with 5) were performed.
*/
class Result_095 {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int checkSorted(List<Integer> arr, boolean isCheckingAsc) {
        int res = 0;
        int n = arr.size();
        TreeMap<Integer, Integer> map;
        if (isCheckingAsc) {
            map = new TreeMap<>();
        } else {
            map = new TreeMap<>(Comparator.reverseOrder());
        }
        for (int i = 0; i < n; i++) {
            int a = arr.get(i);
            map.put(a, i);
        }
        int index = 0;
        int[] buffer = new int[n];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            int toSwap = arr.get(index);
            if (buffer[index] != 0) {
                toSwap = buffer[index];
            }
            if (val != index) {
                map.put(toSwap, val);

                buffer[index] = key;
                buffer[val] = toSwap;

                res++;
            }
            index++;
        }
        return res;
    }

    public static int lilysHomework(List<Integer> arr) {
        int countAsc = checkSorted(arr, true);
        int countDsc = checkSorted(arr, false);
        return Math.min(countAsc, countDsc);
    }
}

public class Solution_095 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_095.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

