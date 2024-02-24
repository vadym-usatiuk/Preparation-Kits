// Sales by Match
// time complexity is O(n)

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
There is a large pile of socks that must be paired by color.
Given an array of integers representing the color of each sock,
determine how many pairs of socks with matching colors there are.
Example n=7 ar = [1,2,1,2,1,3,2] There is one pair of color 1 and one of color 2.
There are three odd socks left, one of each color. The number of pairs is 2.
Function Description Complete the sockMerchant function in the editor below.
sockMerchant has the following parameter(s) :
 • int n : the number of socks in the pile • int ar[n] : the colors of each sock Returns • int :
the number of pairs Input Format The first line contains an integer w, the number of socks represented in ar.
The second line contains W space-separated integers, ar[i], the colors of the socks in the pile.
Constraints . 1 ≤ n ≤ 100 • 1≤arl] ≤ 100 where 0 <i<n
Sample Input STDIN 9 n-9 10 20 20 10 10 30 50 10 20 ar [10, 20, 20, 10, 10, 30, 50, 10, 20)
Sample Output Explanation 10 10 50 10 Function There are three pairs of socks. 30 20
*/
class Result_021 {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> colorCount = new HashMap<>();

        // Count occurrences of each color
        for (int color : ar) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }

        int pairs = 0;
        // Calculate pairs for each color
        for (int count : colorCount.values()) {
            pairs += count / 2;
        }

        return pairs;
    }

}

public class Solution_021 {
    public static void main(String[] args) throws IOException {

        // Test case
        List<Integer> socks = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int pairs = Result_021.sockMerchant(socks.size(), socks);
        System.out.println("Number of pairs: " + pairs);

        // Time complexity analysis
        long startTime = System.nanoTime();

        // Run the function with large input
        int largeInputSize = 1000000;
        List<Integer> largeSocks = new ArrayList<>();
        for (int i = 0; i < largeInputSize; i++) {
            largeSocks.add(i % 100); // Generate random socks
        }
        int largePairs = Result_021.sockMerchant(largeInputSize, largeSocks);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
        System.out.println("Time taken for large input: " + duration + " milliseconds");

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result_021.sockMerchant(n, ar);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
