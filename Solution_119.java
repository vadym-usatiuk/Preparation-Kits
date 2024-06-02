//Mock Test 13 - Cut the Tree
//O(n)

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
There is an undirected tree where each vertex is numbered from 1 to n, and each contains a data value. The sum of a tree is the sum of all its nodes' data values. If an edge is cut, two smaller trees are formed. The difference between two trees is the absolute value of the difference in their sums. Given a tree, determine which edge to cut so that the resulting trees have a minimal difference between them, then return that difference. Example data = [1, 2, 3, 4, 5, 6] edges [(1,2), (1, 3), (2, 6), (3, 4), (3,5)] In this case, node numbers match their weights for convenience. The graph is shown below. 3 2 1 The values are calculated as follows : Edge Tree 1 Tree 2 Absolute Cut Sum Sum Difference 1 8 13 5 2345 9645 12 3 15 9 17 13 5 16 11 The minimum absolute difference is 3. Note : The given tree is always rooted at vertex 1. Function Description Complete the cutThe Tree function in the editor below. cutTheTree has the following parameter(s) : ⚫int data[n] : an array of integers that represent node values ⚫int edges[n-1][2] : an 2 dimensional array of integer pairs where each pair represents nodes connected by the edge
Returns ⚫int : the minimum achievable absolute difference of tree sums Input Format The first line contains an integer n, the number of vertices in the tree. The second line contains n space-separated integers, where each integer u denotes the node[u] data value, data[u]. Each of the n - 1 subsequent lines contains two space-separated integers u and v that describe edge u → v in tree t. Constraints ⚫ 3≤ n ≤105 ⚫1 data[u] ≤1001, where 1 ≤ u≤n. Sample Input STDIN 6 100 200 100 500 100 600 12 6]] 13 23 Function data[] size n = 6 data [100, 200, 100, 500, 100, 600] = edges [[1, 2], [2, 3], [2, 5], [4, 5], [5, 25 45 56 Sample Output 400
Explanation We can visualize the initial, uncut tree as : Vertex 1 100 Vertex 2 200 Vertex 5 Vertex 3 100 100 Vertex 4 Vertex 6 500 600 There are n-1 = 5 edges we can cut : 1. Edge 12 results in d₁2 1500-100 = 1400 2. Edge 2 + 3 results in d23 1500-100 = 1400 = 3. Edge 25 results in d25 1200-400 = 800 = 4. Edge 4 → 5 results in d4.5 =1100-500 = 600 5. Edge 5 + 6 results in ds. The minimum difference is 400. =1000-600 = 400
*/

public class Solution_119 {
    class Result {

        /*
         * Complete the 'cutTheTree' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY data
         *  2. 2D_INTEGER_ARRAY edges
         */

        static int totalSum;
        static int minDiff;
        static int[] subtreeSum;
        static List<List<Integer>> adjList;

        public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
            int n = data.size();
            totalSum = data.stream().mapToInt(Integer::intValue).sum();
            minDiff = Integer.MAX_VALUE;
            subtreeSum = new int[n + 1];
            adjList = new ArrayList<>(n + 1);

            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            boolean[] visited = new boolean[n + 1];
            dfs(1, data, visited);

            return minDiff;
        }

        private static void dfs(int node, List<Integer> data, boolean[] visited) {
            visited[node] = true;
            subtreeSum[node] = data.get(node - 1);

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, data, visited);
                    subtreeSum[node] += subtreeSum[neighbor];
                }
            }

            if (node != 1) {
                int diff = Math.abs(totalSum - 2 * subtreeSum[node]);
                minDiff = Math.min(minDiff, diff);
            }
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<List<Integer>> edges = new ArrayList<>();

            IntStream.range(0, n - 1).forEach(i -> {
                try {
                    edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = Result.cutTheTree(data, edges);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
