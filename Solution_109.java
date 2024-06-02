//Mock Test 12 - Breadth First Search : Shortest Reach
//O(n+m)

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
 2. Breadth First Search : Shortest Reach Consider an undirected graph where each edge weighs 6 units. Each of the nodes is labeled consecutively from 1 to n. You will be given a number of queries. For each query, you will be given a list of edges describing an undirected graph. After you create a representation of the graph, you must determine and report the shortest distance to each of the other nodes from a given starting position using the breadth-first search algorithm (BFS). Return an array of distances from the start node in node number order. If a node is unreachable, return -1 for that node. Example The following graph is based on the listed inputs : 2 1/Start 5 n=5 // number of nodes m = 3 // number of edges edges = [1,2], [1,3], [3,4] s=1 // starting node All distances are from the start node 1. Outputs are calculated for distances to nodes 2 through 5 : [6, 6, 12, -1]. Each edge is 6 units, and the unreachable node 5 has the required return distance of -1. Function Description Complete the bfs function in the editor below. If a node is unreachable, its distance is-1. bfs has the following parameter(s) : ⚫int n : the number of nodes ⚫int m : the number of edges ⚫int edges[m][2] : start and end nodes for edges ⚫ints : the node to start traversals from Returns int[n-1] : the distances to nodes in increasing node number order, not including the start node (-1 if a node is not reachable)
Input Format The first line contains an integer q, the number of queries. Each of the following q sets of lines has the following format : • The first line contains two space-separated integers n and m, the number of nodes and edges in the graph. Each line i of the m subsequent lines contains two space-separated integers, u and v that describe an edge between nodes u and v. The last line contains a single integer, s, the node number to start from. Constraints 1q≤10 ⚫ 2≤ n ≤1000 1≤m≤ n-(n-1) 2 • 1≤ u, v, s≤n Sample Input 241322 42 12 13 31 23 2 Sample Output 66-1 -16
Explanation We perform the following two queries : 1. The given graph can be represented as : 1/Start where our start node, 8, is node 1. The shortest distances from s to the other nodes are one edge to node 2, one edge to node 3, and an infinite distance to node 4 (which it is not connected to). We then return an array of distances from node 1 to nodes 2, 3, and 4 (respectively) : [6, 6, -1]. 2. The given graph can be represented as : 1 2/Start where our start node, s, is node 2. There is only one edge here, so node 1 is unreachable from node 2 and node 3 has one edge connecting it to node 2. We then return an array of distances from node 2 to nodes 1, and 3 (respectively) : [-1,6]. Note : Recall that the actual length of each edge is 6, and we return -1 as the distance to any node that is unreachable from s.
*/
public class Solution_109 {

    class Result {

        /*
         * Complete the 'bfs' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER m
         *  3. 2D_INTEGER_ARRAY edges
         *  4. INTEGER s
         */

        public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int[] distances = new int[n + 1];
            Arrays.fill(distances, -1);
            distances[s] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[node] + 6;
                        queue.add(neighbor);
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i != s) {
                    result.add(distances[i]);
                }
            }

            return result;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                    int n = Integer.parseInt(firstMultipleInput[0]);

                    int m = Integer.parseInt(firstMultipleInput[1]);

                    List<List<Integer>> edges = new ArrayList<>();

                    IntStream.range(0, m).forEach(i -> {
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

                    int s = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> result = Result.bfs(n, m, edges, s);

                    bufferedWriter.write(
                            result.stream()
                                    .map(Object::toString)
                                    .collect(joining(" "))
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
