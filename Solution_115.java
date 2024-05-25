//Cube Summation
//O(m*n*n*n)

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
Define a 3-D Matrix in which each block contains O initially. The first block is defined by the coordinates (1.1.1) and the last block is defined by the coordinates (nurun). There are two types of queries. UPDATE x y z W Update the value of block (xyz) to W. QUERY x1 y1 21 x2 y2 22 Calculate the sum of the values of blocks whose x coordinate is between x1 and x2 (inclusive), y coordinate between yl and y2 (inclusive) and z coordinate between 21 and 22 (inclusive). Function Description Complete the cubeum function in the editor below. cubeSum has the following parameters : -"int nc the dimensions of the 3-d matrix-string operations[m : the operations to perform Returns - int[] : the results of each QUERY operation Input Format The first line contains an integer T, the number of test-cases. T testcases follow. For each test case, the first line contains two space-separated integers, and m. n defines the xxx matrix me defines the number of operations. The next me lines will contain an operation either of these forms : 1. UPDATE x y z W 2. QUERY x1 y1 21 x2 y2 22 Constraints 1ST≤50 1≤ n ≤ 100 15 m≤ 1000 15215225N 15215225 -10° Ve W Vle 10°
Sample Input 2 45 UPDATE 22 24 QUERY 111333 UPDATE 1 1 1 23 QUERY 2 2 2 4 44 QUERY 111333 24 UPDATE 22 21 QUERY 1111 QUERY 11122 QUERY 222 222 Sample Output 0 Explanation In the first test case, there is a cube of 4*4*4 and there are 5 queries. Initially all the cells (1.1.1) to (4.4.4) are 0. UPDATE 22:24 makes the cell (2.2.2) = 4 QUERY 1 1 1 3 3 3. As (2.2.2) is updated to 4 and the rest are all O. The answer to this query is 4. UPDATE 1 1 1 23. updates the cell (1.1.1) to 23. QUERY 2 2 2 4 4 4. Only the cell (1.1.1) and (2.2.2) are non-zero and (1.1.1) is not between (2.2.2) and (4.4.4). So, the answer is 4. QUERY 11 1 3 3 3.2 cells are non-zero and their sum is 23+4 = 27.
*/

public class Solution_115 {
    class Result {

        /*
         * Complete the 'cubeSum' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. STRING_ARRAY operations
         */

        public static List<Long> cubeSum(int n, List<String> operations) {
            long[][][] a = new long[n][n][n];

            List<Long> res = new ArrayList<>();
            for (String s : operations) {
                String[] v = s.split(" ");
                if (s.contains("UPDATE")) {
                    a[Integer.valueOf(v[1]) - 1][Integer.valueOf(v[2]) - 1][Integer.valueOf(v[3]) - 1] = Long.valueOf(v[4]);
                } else {
                    int x1 = Integer.valueOf(v[1]) - 1;
                    int y1 = Integer.valueOf(v[2]) - 1;
                    int z1 = Integer.valueOf(v[3]) - 1;
                    int x2 = Integer.valueOf(v[4]) - 1;
                    int y2 = Integer.valueOf(v[5]) - 1;
                    int z2 = Integer.valueOf(v[6]) - 1;
                    long sum = 0;
                    for (int i = x1; i <= x2; i++) {
                        for (int j = y1; j <= y2; j++) {
                            for (int k = z1; k <= z2; k++) {
                                sum += a[i][j][k];
                            }
                        }
                    }
                    res.add(sum);
                }
            }
            return res;

        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int T = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, T).forEach(TItr -> {
                try {
                    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                    int matSize = Integer.parseInt(firstMultipleInput[0]);

                    int m = Integer.parseInt(firstMultipleInput[1]);

                    List<String> ops = IntStream.range(0, m).mapToObj(i -> {
                                try {
                                    return bufferedReader.readLine();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            })
                            .collect(toList());

                    List<Long> res = Result.cubeSum(matSize, ops);

                    bufferedWriter.write(
                            res.stream()
                                    .map(Object::toString)
                                    .collect(joining("\n"))
                                    + "\n"
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
