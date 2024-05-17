//Castle on the Grid
//O(n*n)

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
You are given a square grid with some cells open (.) and some blocked (X). Your playing piece can move along any row or column until it reaches the edge of the grid or a blocked cell. Given a grid, a start and a goal, determine the minmum number of moves to get to the goal. Example. grid = ['...','.X.','...'"] start X = 0 startY = 0 goalX = 1 goalY = 2 The grid is shown below : .X. The starting position (startX, startY) = (0, 0) so start in the top left corner. The goal is (goalX, goalY) = (1, 2). The path is (0,0) → (0,2)→ (1,2). It takes 2 moves to reach the goal. Function Description Complete the minimum Moves function in the editor. minimumMoves has the following parameter(s) : ⚫string grid[n] : an array of strings that represent the rows of the grid ⚫int startX : starting X coordinate ⚫int startY : starting Y coordinate int goalX : ending X coordinate int goalY : ending Y coordinate Returns int : the minimum moves to reach the goal Input Format The first line contains an integer n, the size of the array grid. Each of the next in lines contains a string of length n. The last line contains four space-separated integers, startX, startY, goalX, goalY
Sample Input STDIN FUNCTION 3 grid[] size n = 3 .X. grid ['.X.','.X.', .x. 0 0 0 2 startX 0, startY = 0, goalX = 0, goalY = 2 Sample Output Explanation Here is a path that one could follow in order to reach the destination in 3 steps : → (0,0) (2,0) (2,2) → (0,2). →
*/

public class Solution_107 {

    class Result {

        /*
         * Complete the 'minimumMoves' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING_ARRAY grid
         *  2. INTEGER startX
         *  3. INTEGER startY
         *  4. INTEGER goalX
         *  5. INTEGER goalY
         */

        public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
            int n = grid.size();
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startX, startY, 0});
            visited[startX][startY] = true;

            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int moves = current[2];

                if (x == goalX && y == goalY) {
                    return moves;
                }

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    while (newX >= 0 && newX < n && newY >= 0 && newY < n && grid.get(newX).charAt(newY) == '.') {
                        if (!visited[newX][newY]) {
                            visited[newX][newY] = true;
                            queue.offer(new int[]{newX, newY, moves + 1});
                        }
                        newX += dir[0];
                        newY += dir[1];
                    }
                }
            }

            return -1;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int startX = Integer.parseInt(firstMultipleInput[0]);

            int startY = Integer.parseInt(firstMultipleInput[1]);

            int goalX = Integer.parseInt(firstMultipleInput[2]);

            int goalY = Integer.parseInt(firstMultipleInput[3]);

            int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
