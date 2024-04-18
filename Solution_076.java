//The Coin Change Problem
//O(n*m)

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
Given an amount and the denominations of coins available, determine how many ways change can be made for amount. There is a limitless supply of each coin type. Example n = 3 c = [8,3,1,2] There are 3 ways to make change for n = 3 : {1,1,1}. {1,2}, and {3}. Function Description Complete the getWays function in the editor below. getWays has the following parameter(s) : ⚫int n : the amount to make change for ⚫ int c[m] : the available coin denominations Returns ⚫int : the number of ways to make change Input Format The first line contains two space-separated integers n and m, where : n is the amount to change m is the number of coin types The second line contains m space-separated integers that describe the values of each coin type. Constraints ⚫ 1≤c[i] ≤50 ⚫ 1≤ n ≤250 ⚫ 1≤m≤50 Each c[i] is guaranteed to be distinct. Hints Solve overlapping subproblems using Dynamic Programming (DP) : You can solve this problem recursively but will not pass all the test cases without optimizing to eliminate the overlapping subproblems. Think of a way to store and reference previously computed solutions to avoid solving the same subproblem multiple times. * Consider the degenerate cases : - How many ways can you make change for 0 cents? - How many ways can you make change for >0 cents if you have no coins? *If you're having trouble defining your solutions store, then think about it in terms of the base case (n= 0). - The answer may be larger than a 32-bit integer.
*/

class Result_076 {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
        long[] ways = new long[n + 1];
        ways[0] = 1;

        for (long coin : c) {
            for (int i = (int) coin; i <= n; i++) {
                ways[i] += ways[i - (int) coin];
            }
        }
        return ways[n];
    }
}

public class Solution_076 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result_076.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

