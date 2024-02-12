//Lonely Integer

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

class Result_009 {

    /*
Given an array of integers, where all elements but one occur twice, find the unique element.
Example a = [1, 2, 3, 4, 3, 2, 1] The unique element is 4.
Function Description Complete the lonelyinteger function in the editor below.
lonelyinteger has the following parameter(s) :
• int a[n] : an array of integers Returns int :
the element that occurs only once Input Format
The first line contains a single integer, n, the number of integers in the array.
The second line contains n space-separated integers that describe the values in a.
Constraints • 1 ≤ n < 100 • It is guaranteed that n is an odd number and that there is one unique element.
0 ≤ a[i] ≤ 100, where 0 < i <n.
*/

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each integer in the list

        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the unique element
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // If no unique element found, return -1 or throw an exception
        return -1; // Or throw new RuntimeException("No unique element found");
    }
}

public class Solution_009 {
    public static void main(String[] args) throws IOException {
        //Local only
        // Input array of integers
        List<Integer> testArray = Arrays.asList(1, 2, 3, 4, 3, 2, 1);

        // Test lonelyinteger function
        int result = Result_009.lonelyinteger(testArray);

        // Print result
        System.out.println("The lonely integer is: " + result);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result_009.lonelyinteger(a);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
