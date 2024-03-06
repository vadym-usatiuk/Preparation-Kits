//Dynamic Array
//O(q)

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
• Declare a 2-dimensional array, arr, of n empty arrays. All arrays are zero indexed.
• Declare an integer, last Answer, and initialize it to 0.
• There are 2 types of queries, given as an array of strings for you to parse :
1. Query :
1 x y 1. Let ida= ((z last Answer) %n).
2. Append the integer y to arrida].

2. Query : 2 x y
1. Let idr = ( (z last Answer) % n).
2. Assign the value arr[idx][y % size(arr[idx])] to last Answer.
3. Store the new value of last Answer to an answers array.
Note : is the bitwise XOR operation, which corresponds to the operator in most languages.
Learn more about it on Wikipedia. % is the modulo operator.
Finally, size(arr[idx]) is the number of elements in arr[idx]
Function Description
 Complete the dynamicArray function below. dynamicArray has the following parameters : - int n :
 the number of empty arrays to initialize in arr -string queries[q] : query strings that contain 3
 space-separated integers Returns • int[] : the results of each type 2 query in the order they are presented
 Input Format The first line contains two space-separated integers, n, the size of arr to create, and g,
 the number of queries, respectively. Each of the subsequent lines contains a query string, queries [i].
 Constraints • 1 ≤n, q≤ 105 • 0 ≤z, y ≤ 10³ • It is guaranteed that query type
 2 will never query an empty array or index. Sample Input 25 105 117 103 210 211 Sample Output 7 3

 Explanation Initial Values : n = 2 last Answer = 0 arr [0] = [] arr[1] = []
 Query 0 : Append 5 to arr[( (00) % 2 )] = arr[0]. last Answer = 0 arr [0] = [5] arr[1] = []
 Query 1 : Append 7 to arr[( (10) % 2 )] = arr[1]. arr [0] = [5] arr[1] = [7]
 Query 2 : Append 3 to arr[( (0 0 0) % 2 )] = arr[0]. last Answer = 0 arr[0] = [5, 3] arr[1] = [7]
 Query 3 : Assign the value at index 0 of arr[( (10) % 2 )] = arr[1] to last Answer,
  print last Answer. last Answer = 7 arr[0] = [5,3] arr[1] = [7] 7
  Query 4 : Assign the value at index 1 of arr[((17) % 2 )] = arr[0] to last Answer, print last Answer.
  last Answer = 3 arr [0] = [5,3] arr[1] - [7] 3
*/
class Result_038 {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> lastAnswers = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>(n);
        int lastAnswer = 0;

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            if (queryType == 1) {
                int idx = (x ^ lastAnswer) % n;
                arr.get(idx).add(y);
            } else if (queryType == 2) {
                int idx = (x ^ lastAnswer) % n;
                int size = arr.get(idx).size();
                lastAnswer = arr.get(idx).get(y % size);
                lastAnswers.add(lastAnswer);
            }
        }

        return lastAnswers;
    }

}

public class Solution_038 {
    public static void main(String[] args) throws IOException {

        // Test case 1
        List<List<Integer>> queries1 = new ArrayList<>();
        queries1.add(List.of(1, 0, 5));
        queries1.add(List.of(1, 1, 7));
        queries1.add(List.of(1, 0, 3));
        queries1.add(List.of(2, 1, 0));
        queries1.add(List.of(2, 1, 1));

        List<Integer> result1 = Result_038.dynamicArray(2, queries1);
        System.out.println("Test case 1 result: " + result1); // Expected output: [7, 3]

        // Test case 2
        List<List<Integer>> queries2 = new ArrayList<>();
        queries2.add(List.of(1, 0, 1));
        queries2.add(List.of(1, 0, 2));
        queries2.add(List.of(2, 0, 0));
        queries2.add(List.of(2, 1, 0));

        List<Integer> result2 = Result_038.dynamicArray(2, queries2);
        System.out.println("Test case 2 result: " + result2); // Expected output: [1, 2]

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int q = Integer.parseInt(firstMultipleInput[1]);
//
//        List<List<Integer>> queries = new ArrayList<>();
//
//        IntStream.range(0, q).forEach(i -> {
//            try {
//                queries.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<Integer> result = Result_038.dynamicArray(n, queries);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
