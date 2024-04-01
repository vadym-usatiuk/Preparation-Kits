//Mock Test 7 - Big Sorting
//O(n * log n)

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

/*1. Big Sorting Consider an array of numeric strings where each string is a positive number
 with anywhere from 1 to 106 digits. Sort the array's elements in non-decreasing,
 or ascending order of their integer values and return the sorted array.
 Example unsorted = ['1', '200', '150', '3'] Return the array ['1', '3', '150', '200'].
 Function Description Complete the bigSorting function in the editor below.
 bigSorting has the following parameter(s) :
 ⚫ string unsorted[n] : an unsorted array of integers as strings Returns
 ⚫string[n] : the array sorted in numerical order Input Format The first line contains an integer, n,
 the number of strings in unsorted. Each of the n subsequent lines contains an integer string, unsorted[i].
 Constraints • 1≤ n ≤2 × 105 • Each string is guaranteed to represent a positive integer.
 •There will be no leading zeros. • The total number of digits across all strings in unsorted is
 between 1 and 10º (inclusive).*/
/*
Sample Input 0 6 31415926535897932384626433832795 1 3 10 3 5
Sample Output 0 3 5 10 31415926535897932384626433832795
Explanation 0 The initial array of strings is unsorted [31415926535897932384626433832795, 1, 3, 10, 3, 5].
When we order each string by the real-world integer value it represents,
we get : 1<3<3≤5 1031415926535897932384626433832795 We then print each value on a new line,
from smallest to largest.
Sample Input 1 B 1 2 100 12303479849857341718340192371 3084193741082937 3084193741082938 111 200
Sample Output 1 1 2 100 111 200 3084193741082937 3084193741082938 12303479849857341718340192371
*/
class Result_062 {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
        unsorted.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });
        return unsorted;
    }
}

public class Solution_062 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result_062.bigSorting(unsorted);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

