//Stock Maximize
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

/*
Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next number of days. Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy? Example prices = [1,2] Buy one share day one, and sell it day two for a profit of 1. Return 1. prices = [2,1] No profit can be made so you do not buy or sell stock those days. Return 0. Function Description Complete the stockmax function in the editor below. stockmax has the following parameter(s) : ⚫prices : an array of integers that represent predicted daily stock prices Returns ⚫int : the maximum profit achievable Input Format The first line contains the number of test cases t Each of the next & pairs of lines contain : -The first line contains an integer n, the number of predicted prices for WOT. -The next line contains n space-separated integers prices[i]. each a predicted stock price for day i. Constraints ⚫ 1≤t≤10 ⚫ 1≤ n ≤ 50000 1 prices[i] < 100000 Output Format Output { lines, each containing the maximum profit which can be obtained for the corresponding test case.
Sample Input STDIN Function M M 3 q=3 3 prices size n = 3 532 prices = [5.3.2] 4 3 12100 prices [1.2.100] 1312 prices [1.3.1.2] prices size n = 3 prices size n = 4 Sample Output 197 013 Explanation For the first case, there is no profit because the share price never rises, return 0. For the second case, buy one share on the first two days and sell both of them on the third day for a profit of 197. For the third case, buy one share on day 1, sell one on day 2. buy one share on day 3, and sell one share on day 4. The overall profit is 3.
*/

class Result_073 {

    /*
     * Complete the 'stockmax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY prices as parameter.
     */

    public static long stockmax(List<Integer> prices) {
        long maxProfit = 0;
        int maxFuturePrice = 0;

        for (int i = prices.size() - 1; i >= 0; i--) {
            if (prices.get(i) > maxFuturePrice) {
                maxFuturePrice = prices.get(i);
            }
            maxProfit += maxFuturePrice - prices.get(i);
        }

        return maxProfit;
    }

}

public class Solution_073 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = Result_073.stockmax(prices);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

