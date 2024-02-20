//Matrix Sean
//Time complexity is O(n*n)

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

/*1. Flipping the Matrix Sean invented a game involving a 21 x 21 matrix
where each cell of the matrix contains an integer. He can reverse any
of its rows or columns any number of times. The goal of the game is to
maximize the sum of the elements in the 11 X 12 submatrix located in the upper-left quadrant of the matrix.
Given the initial configurations for q matrices,
help Sean reverse the rows and columns of each matrix in the best possible way
so that the sum of the elements in the matrix's upper-left quadrant is maximal.
Example matrix = [[1,2], [3, 4]] 12 It is 2 x 2 and we want to maximize the top left quadrant,
a 1 x 1 matrix. Reverse row 1 : 12 And now reverse column 0 : 42 13 The maximal sum is 4.
Function Description Complete the flippingMatrix function in the editor below.
flipping Matrix has the following parameters : - int matrix[2n][2n] :
a 2-dimensional array of integers Returns -int : the maximum sum possible.
Input Format The first line contains an integer q. the number of queries.
The next q sets of lines are in the following format : • The first line of each query contains an integer, n.
• Each of the next 2 lines contains 2n space-separated integers matriz[i][j] in row of the matrix.
Constraints • 1≤q≤ 16 . • 1 ≤ n ≤ 128 • 0≤ matriz[i][j] ≤ 4096, where 0 ≤i, j<2n.
Sample Input STDIN 1 2 112 42 83 119 matrix [[112, 42, 83, 119), ([56, 125, 56, 49), \ 56 125 56 49 [15, 78, 101, 43],
[62, 98, 114, 108]] 15 78 101 43 62 98 114 108 Sample Output Function 414 9-1
Explanation Start out with the following 2n x 2n matrix : matrix = 112 56 15 62
Perform the following operations to maximize the sum of the X n submatrix in the upper-left quadrant :
 2. Reverse column 2 ([83, 56, 101, 114] [114, 101, 56, 83]),
 resulting in the matrix : →
 matria = 42 83 119 125 56 49 78 101 43 98 114 108 112 42 114 1197 56 125 101 49 15 78 56 43 62 98 83 108 3.
 Reverse row 0 ([112, 42, 114, 119] → [119, 114, 42, 112]),
 resulting in the matrix : 119 114 42 56 125 101 112 49 15 78 56 43 62 98 83 108
 The sum of values in the 12 X 12 submatrix in the upper-left quadrant is 119 + 114 +56 +125= 414.
*/
class Result_017 {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int n = matrix.size() / 2;
        int maxSum = 0;
        // Iteration thorough the upper-left side/quadrant of this matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Choose the maximum of elements
                int val = Math.max(matrix.get(i).get(j), Math.max(matrix.get(i).get(2 * n - 1 - j),
                        Math.max(matrix.get(2 * n - 1 - i).get(j),
                                matrix.get(2 * n - 1 - i).get(2 * n - 1 - j))));
                maxSum += val;
            }
        }

        return maxSum;
    }

    public static void testFlippingMatrix() {
        // Test case
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108)
        );
        int result = flippingMatrix(matrix);
        System.out.println("Maximal sum: " + result);
    }

}

public class Solution_017 {
    public static void main(String[] args) throws IOException {
        //local
        Result_017.testFlippingMatrix();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<List<Integer>> matrix = new ArrayList<>();
//
//                IntStream.range(0, 2 * n).forEach(i -> {
//                    try {
//                        matrix.add(
//                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                        .map(Integer::parseInt)
//                                        .collect(toList())
//                        );
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//                int result = Result_017.flippingMatrix(matrix);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
