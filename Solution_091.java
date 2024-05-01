//Queries with Fixed Length
//O(nq)

/*
Consider an n-integer sequence, A = {a0, a1,..., -1}. We perform a query on A by using an integer. d. to calculate the result of the following expression : min (max a;) 0≤i≤n-d i<j<i+d In other words, if we let m₁ = max(a, d+1, +2,...,i+d-1). then you need to calculate min(m), m₁, ……., ma-a). Given arr and q queries, return a list of answers to each query. Example arr = [2,3,4,5,6] queries = [2,3] The first query uses all of the subarrays of length 2 : [2, 3], [3, 4], [4, 5], [5, 6]. The maxima of the subarrays are [3,4,5,6]. The minimum of these is 3 The second query uses all of the subarrays of length 3 : [2, 3, 4], [3,4,5], [4, 5, 6]. The maxima of the subarrays are [4, 5, 6]. The minimum of these is 4. Return [3,4]. Function Description Complete the solve function below. solve has the following parameter(s) : ⚫ int arr[n] : an array of integers ⚫int queries[q] : the lengths of subarrays to query Returns ⚫ int[q] : the answers to each query Input Format The first line consists of two space-separated integers, 1 and q. The second line consists of n space-separated integers, the elements of arr. Each of the q subsequent lines contains a single integer denoting the value of d for that query. Constraints ⚫ 1≤ n ≤105 ⚫ 0≤ arr[i] <10% ⚫ 1≤q≤100 • 1≤d≤n
Sample Input

5 5
1 2 3 4 5
1
2
3
4
5
Sample Output

1
2
3
4
5
Explanation

Each prefix has the least maximum value among the consecutive subsequences of the same size.
*/

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
 * Complete the 'solve' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY arr
 *  2. INTEGER_ARRAY queries
 */

class Result_091 {

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        List<Integer> results = new ArrayList<>();

        for (int d : queries) {
            int minMax = Integer.MAX_VALUE;

            Deque<Integer> window = new LinkedList<>();

            for (int i = 0; i < d; i++) {
                while (!window.isEmpty() && arr.get(i) >= arr.get(window.peekLast())) {
                    window.removeLast();
                }
                window.addLast(i);
            }

            for (int i = d; i <= arr.size(); i++) {
                minMax = Math.min(minMax, arr.get(window.peekFirst()));

                while (!window.isEmpty() && window.peekFirst() <= i - d) {
                    window.removeFirst();
                }

                if (i < arr.size()) {
                    while (!window.isEmpty() && arr.get(i) >= arr.get(window.peekLast())) {
                        window.removeLast();
                    }
                    window.addLast(i);
                }
            }
            results.add(minMax);
        }
        return results;
    }
}

public class Solution_091 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result_091.solve(arr, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

