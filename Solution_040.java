//Missing Numbers
//O(n + m + k log k)

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
Given two arrays of integers, find which elements in the second array are missing from the first array.
Example arr = [7,2,5,3,5,3] brr [7,2,5,4,6,3,5,3] = The brr array is the orginal list.
The numbers missing are [4,6]. Notes . If a number occurs multiple times in the lists,
you must ensure that the frequency of that number in both lists is the same. If that is not the case,
then it is also a missing number.
 Return the missing numbers sorted ascending
• Only include a missing number once, even if it is missing multiple times. .
The difference between the maximum and minimum numbers in the original list is less than or equal to 100.
Function Description Complete the missingNumbers function in the editor below.
It should return a sorted array of missing numbers. missingNumbers has the following parameter(s) :
⚫int arr[n] : the array with missing numbers
⚫int brr[m] : the original array of numbers Returns
⚫int : an array of integers Input Format There will be four lines of input -the size of the first list,
arr The next line contains a space-separated integers arr[i] m-the size of the second list,
brr The next line contains m space-separated integers brr[i]
Constraints
⚫ 1≤ n,m ≤2×105 • n≤m
⚫ 1≤ brri≤10
⚫ max(brr)-min(brr) ≤100
Sample Input 10 203 204 205 206 207 208 203 204 205 206 13 203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output 204 205 206 Explanation 204 is present in both arrays.
Its frequency in arr is 2. while its frequency in brr is 3. Similarly,
205 and 206 occur twice in arr, but three times in brr.
The rest of the numbers have the same frequencies in both lists.
*/
class Result_040 {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> freqArr = new HashMap<>();
        Map<Integer, Integer> freqBrr = new HashMap<>();

        for (int num : arr) {
            freqArr.put(num, freqArr.getOrDefault(num, 0) + 1);
        }

        for (int num : brr) {
            freqBrr.put(num, freqBrr.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqBrr.entrySet()) {
            int num = entry.getKey();
            int freqInBrr = entry.getValue();
            int freqInArr = freqArr.getOrDefault(num, 0);

            if (freqInBrr > freqInArr) {
                result.add(num);
            }
        }

        Collections.sort(result);

        return result;
    }

    public static void testMissingNumbers() {
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);
        List<Integer> expected = Arrays.asList(204, 205, 206);

        List<Integer> result = missingNumbers(arr, brr);

        if (expected.equals(result)) {
            System.out.println("Test Passed: Missing Numbers - " + result);
        } else {
            System.out.println("Test Failed: Missing Numbers - " + result);
        }
    }
}

public class Solution_040 {
    public static void main(String[] args) throws IOException {
        Result_040.testMissingNumbers();

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int m = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result_040.missingNumbers(arr, brr);
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

