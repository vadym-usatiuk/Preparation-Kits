//Grid Challenge
//O(n^2 * log n)

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
Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically,
ascending. Determine if the columns are also in ascending alphabetical order, top to bottom.
Return YES if they are or NO if they are not. Example grid=['abe','ade', 'efg'] The grid is illustrated below.
The rows are already in alphabetical order. The columns a a e. b d f and c e g are also in alphabetical order,
so the answer would be YES. Only elements within the same row can be rearranged.
They cannot be moved to a different row. Function Description Complete the gridChallenge function in the editor below.
gridChallenge has the following parameter(s) : string grid[n] : an array of strings Returns string :
either YES or NO Input Format The first line contains t, the number of testcases.
Each of the next t sets of lines are described as follows : -The first line contains 1,
the number of rows and columns in the grid.
The next lines contains a string of length n Constraints 1st≤100 1≤ n ≤100
Each string consists of lowercase letters in the range ascii[a-z] Output Format For each test case,
on a separate line print YES if it is possible to rearrange the grid alphabetically ascending in both
its rows and columns, or NO otherwise. Sample Input STDIN Function 1 t-1 5 n-5 ebacd grid ['ebacd', 'fghij',
'olakn', 'trpqs', 'xywuv'] fghij olmkn trpqs xywuv Sample Output YES Explanation
The 5x5 grid in the 1 test case can be reordered to
*/
class Result_042 {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Iterate through each row and sort the characters alphabetically
        for (int i = 0; i < grid.size(); i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row);
            grid.set(i, new String(row));
        }

        // Iterate through each column and check if it's in ascending alphabetical order
        for (int j = 0; j < grid.get(0).length(); j++) {
            for (int i = 1; i < grid.size(); i++) {
                if (grid.get(i).charAt(j) < grid.get(i - 1).charAt(j)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

}

public class Solution_042 {
    public static void main(String[] args) throws IOException {

        List<String> grid = Arrays.asList("ebacd", "fghij", "olakn", "trpqs", "xywuv");
        String result = Result_042.gridChallenge(grid);
        System.out.println(result); // Output: YES
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
//                            try {
//                                return bufferedReader.readLine();
//                            } catch (IOException ex) {
//                                throw new RuntimeException(ex);
//                            }
//                        })
//                        .collect(toList());
//
//                String result = Result_042.gridChallenge(grid);
//
//                bufferedWriter.write(result);
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
