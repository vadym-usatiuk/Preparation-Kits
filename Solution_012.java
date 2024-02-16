//Diagonal Difference
//time complexity is O(n*n)
//space complexity is O(1)

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

class Result_012 {


/*
    Given a square matrix, calculate the absolute difference between the sums of its diagonals.
    For example, the square matrix arr is shown below : 123 456 989 The left-to-right diagonal=1+5+9= 15.
    The right to left diagonal=3+5+9=17. Their absolute difference is 15 - 17 = 2
    Function description Complete the diagonalDifference function in the editor below.
    diagonalDifference takes the following parameter : • Int arr[n][m] an array of integers Return Int :
    the absolute diagonal difference Input Format The first line contains a single integer, n,
    the number of rows and columns in the square matrix arr. Each of the next lines describes a row, arr[],
    and consists of space separated integers arr[1][11]. Constraints -100 ≤ arr≤ 100
    Output Format Return the absolute difference between the sums of the matrix's two diagonals as a single integer.
    Sample Input 11 24 456 18 8 -12 Sample Output 15 Explanation The primary diagonal is : 11 -12
    Sum across the primary diagonal : 11+5-12=4 The secondary diagonal is : 18
    Sum across the secondary diagonal : 4+5+10= 19 Difference : 14-19 15
    Note : x is the absolute value of x
*/


    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> row = arr.get(i);
            primaryDiagonalSum += row.get(i);
            secondaryDiagonalSum += row.get(n - i - 1);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    public static void testDiagonalDifference() {
        List<List<Integer>> matrix1 = new ArrayList<>();
        matrix1.add(Arrays.asList(11, 2, 4));
        matrix1.add(Arrays.asList(4, 5, 6));
        matrix1.add(Arrays.asList(10, 8, -12));
        System.out.println("Test Case 1: " + diagonalDifference(matrix1)); // Expected output: 15

        List<List<Integer>> matrix2 = new ArrayList<>();
        matrix2.add(Arrays.asList(1, 2, 3));
        matrix2.add(Arrays.asList(4, 5, 6));
        matrix2.add(Arrays.asList(7, 8, 9));
        System.out.println("Test Case 2: " + diagonalDifference(matrix2)); // Expected output: 0
    }

}

public class Solution_012 {
    public static void main(String[] args) throws IOException {
        //Local
        Result_012.testDiagonalDifference();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> arr = new ArrayList<>();
//
//        IntStream.range(0, n).forEach(i -> {
//            try {
//                arr.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        int result = Result_012.diagonalDifference(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
