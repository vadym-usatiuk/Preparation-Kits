//Picking Numbers
//O(n)

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

/*Given an array of integers, find the longest subarray where the absolute difference between any two
        elements is less than or equal to 1. Example a = [1, 1, 2, 2, 4, 4, 5, 5,5]
        There are two subarrays meeting the criterion : [1, 1, 2, 2] and [4, 4, 5, 5, 5].
        The maximum length subarray has 5 elements.
        Function Description
        Complete the pickingNumbers function in the editor below. pickingNumbers has the following parameter(s) :
        • int a[n] : an array of integers Returns • int : the length of the longest subarray that meets the criterion
        Input Format The first line contains a single integer 1,
        the size of the array a The second line contains n space-separated integers, each an a[i].
        Constraints • 2 ≤ n ≤ 100 • 0 <a[i]<100 • The answer will be ≥ 2.*/
class Result_027 {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;
        for (int num : frequencyMap.keySet()) {
            int lengthIncludingCurrent = frequencyMap.getOrDefault(num, 0) +
                    frequencyMap.getOrDefault(num + 1, 0);
            maxLength = Math.max(maxLength, lengthIncludingCurrent);
        }

        return maxLength;
    }


}

public class Solution_027 {
    public static void main(String[] args) throws IOException {

        // Test case 1
        List<Integer> test1 = Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5);
        int result1 = Result_027.pickingNumbers(test1);
        System.out.println("Test case 1: " + result1); // Expected output: 5

        // Test case 2
        List<Integer> test2 = Arrays.asList(4, 4, 4, 4, 4, 4);
        int result2 = Result_027.pickingNumbers(test2);
        System.out.println("Test case 2: " + result2); // Expected output: 6

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result_027.pickingNumbers(a);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
