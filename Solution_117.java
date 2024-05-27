//Minimum Loss 1
//O(nlogn)

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
Lauren has a chart of distinct projected prices for a house over the next several years. She must buy the house in one year and sell it in another, and she must do so at a loss. She wants to minimize her financial loss. Example price [20, 15, 8, 2, 12] Her minimum loss is incurred by purchasing in year 2 at price [1] = 15 and reselling in year 5 at price[4] = 12. Return 15-12= 3. Function Description Complete the minimumLoss function in the editor below. minimumLoss has the following parameter(s) : int price[n] : home prices at each year Returns int : the minimum loss possible Input Format The first line contains an integer n, the number of years of house data. The second line contains n space-separated long integers that describe each price[i]. Constraints • 2≤ n ≤2 x 105 1 price[i] <1016 • All the prices are distinct. • A valid answer exists. Subtasks • 2n≤1000 for 50% of the maximum score.
*/

public class Solution_117 {
    class Result {

        /*
         * Complete the 'minimumLoss' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts LONG_INTEGER_ARRAY price as parameter.
         */

        public static int minimumLoss(List<Long> price) {
            // Write your code here

            int n = price.size();
            long loss = Integer.MAX_VALUE;

            long lastPrice = 0;
            int lastIdx = 0;

            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < n; i++) {
                map.put(price.get(i), i);
            }

            for (Map.Entry<Long, Integer> e : map.entrySet()) {
                long curPrice = e.getKey();
                int curIdx = e.getValue();

                if (curIdx < lastIdx) {
                    loss = Math.min(loss, curPrice - lastPrice);
                }

                lastPrice = curPrice;
                lastIdx = curIdx;
            }

            return (int) loss;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Long::parseLong)
                    .collect(toList());

            int result = Result.minimumLoss(price);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
