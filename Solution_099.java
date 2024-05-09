//Mock Test 11 - Connected Cells in a Grid
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
Consider a matrix where each cell contains either a 0 or a 1. Any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. In the following grid, all cells marked x are connected to the cell marked Y. XXX XYX XXX If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to zero or more cells in the region but is not necessarily directly connected to all the other cells in the region. Given an xm matrix, find and print the number of cells in the largest region in the matrix. Note that there may be more than one region in the matrix. For example, there are two regions in the following 3 x 3 matrix. The larger region at the top left contains 3 cells. The smaller one at the bottom right contains 1. 110 100 001 Function Description Complete the connected Cell function in the editor below. connected Cell has the following parameter(s) : -int matrix[n][m] : matrix[i] represents the throw of the matrix Returns -int : the area of the largest region Input Format The first line contains an integer 1, the number of rows in the matrix. The second line contains an integer m, the number of columns in the matrix. Each of the next lines contains ma space-separated integers matriz|ij| Constraints 0<n, m<10 Sample Input STDIN Function 4 4 1100 01 10 0010 1000 n-4 m-4 grid [[1, 1, 1, 0], [0, 1, 1, 0], [0, 0, 1, 0], [1, 0, 0, 0]] Sample Output Explanation The diagram below depicts two regions of the matrix. Connected regions are filled with X or Y. Zeros are replaced with dots for clarity. xx.. XX. X. Y... The larger region has 5 cells, marked x.
*/

class Result_099 {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int connectedCell(List<List<Integer>> matrix) {
        int maxRegionSize = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    int currentRegionSize = dfs(matrix, i, j);
                    maxRegionSize = Math.max(maxRegionSize, currentRegionSize);
                }
            }
        }
        return maxRegionSize;
    }

    private static int dfs(List<List<Integer>> matrix, int row, int col) {
        if (row < 0 || row >= matrix.size() || col < 0 || col >= matrix.get(0).size() || matrix.get(row).get(col) == 0) {
            return 0;
        }
        matrix.get(row).set(col, 0);
        int size = 1;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    size += dfs(matrix, row + dr, col + dc);
                }
            }
        }
        return size;
    }
}

public class Solution_099 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result_099.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

