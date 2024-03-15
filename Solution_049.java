//Forming a Magic Square
//O(1)

/*
We define a magic square to be an x matrix of distinct positive integers from 1 to 2 where the sum of any row,
column, or diagonal of length is always equal to the same number : the magic constant.
You will be given a 3 x 3 matrix of integers in the inclusive range [1,9].
We can convert any digita to any other digit in the range [1,9] at cost of lab.
Given &, convert it into a magic square at minimal cost. Print this cost on a new line.
Note : The resulting magic square must contain distinct integers in the inclusive range [1,9].
Example Ss [15, 3, 4], [1, 5, 81, 16, 4,211 The matrix looks like this : 534 158 642
We can convert it to the following magic square : 834 159 672
This took three replacements at a cost of 15-8+18-91+4 77.1
Function Description Complete the formingMagicSquare function in the editor below.
formingMagicSquare has the following parameter(s) : ■ints[3][3] : a 3 x 3 array of integers Returns int :
the minimal total cost of converting the input square to a magic square Input Format Each of the $
lines contains three space separated Integers of rows[i]. Constraints 1,9]
Sample Input 357 815
Sample Output 1
Explanation Matrix initially looks like this : 492 357 815 Observe that it's not yet magic,
because not all rows, columns, and center diagonals sum to the same number.
If we change the bottom right value, s[2][2], from 5 to 6 at a cost of 16-5=1,
becomes a magic square at the minimum possible cost. Thus, we print the cost, 1, on a new line.
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

class Result_049 {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][][] magicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        int minCost = Integer.MAX_VALUE;
        for (int[][] magicSquare : magicSquares) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(s.get(i).get(j) - magicSquare[i][j]);
                }
            }
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

}

public class Solution_049 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result_049.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

