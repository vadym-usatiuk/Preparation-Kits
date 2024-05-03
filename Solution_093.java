//Array Manipulation
//O(n + m)

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
Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array. Example n = 10 queries = [[1,5, 3], [4, 8, 7], [6, 9, 1] Queries are interpreted as follows : abk 153 487 691 Add the values of k between the indices a and b inclusive : index-> 1 2 3 4 5 6 7 8 9 10 [0.0.0.0.0.0.0.0.0, 0] [3.3.3, 3, 3.0.0.0.0, 0] [3.3.3.10.10.7.7.7.0. 0] [3.3.3.10.10.8.8.8.1, 0] The largest value is 10 after all operations are performed. Function Description Complete the function arrayManipulation in the editor below. arrayManipulation has the following parameters : int n - the number of elements in the array int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k. Returns ⚫int - the maximum value in the resultant array Input Format The first line contains two space-separated integers n and m. the size of the array and the number of operations. Each of the next m lines contains three space-separated integers a, b and k, the left index, right index and summand. Constraints 3≤ n ≤107 •1≤m≤2.105 • 1≤a≤b≤n ⚫ 0≤ k ≤10⁹
Sample Input 53 12 100 25 100 34 100 Sample Output 200 Explanation After the first update the list is 100 100 0 0 e. After the second update list is 100 200 100 100 100. After the third update list is 100 200 200 200 100. The maximum value is 200.
*/

class Result_093 {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 1];

        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);
            arr[a - 1] += k;
            arr[b] -= k;
        }

        long max = 0;
        long sum = 0;
        for (long num : arr) {
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}

public class Solution_093 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result_093.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

