//Prim's (MST) : Special Subtree
//O(log E)

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
Given a graph which consists of several edges connecting its nodes, find a subgraph of the given graph with the following properties : The subgraph contains all the nodes present in the original graph. The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs. It is also required that there is exactly one, exclusive path between any two nodes of the subgraph. One specific node S is fixed as the starting point of finding the subgraph using Prim's Algorithm. Find the total weight or the sum of all edges in the subgraph. Example n = 3 edges [[1, 2, 2], [2, 3, 2], [1, 3, 3]] = start=1 2 1 3 3 Starting from node 1. select the lower weight edge, i.e. 1 2. weight 2. Choose between the remaining edges. 1 3. weight 3. and 23. weight 2. The lower weight edge is 2 + 3 weight 2. All nodes are connected at a cost of 2+2 = 4. The edge 13 is not included in the subgraph. Function Description Complete the prims function in the editor below. prims has the following parameter(s) : int n : the number of nodes in the graph int edges[m][3] : each element contains three integers, two nodes numbers that are connected and the weight of that edge int start : the number of the starting node
Returns int : the minimum weight to connect all nodes in the graph Input Format The first line has two space-separated integers n and m, the number of nodes and edges in the graph. Each of the next m lines contains three space-separated integers u. and w, the end nodes of edges[i], and the edge's weight. The last line has an integer start. the starting node. Constraints 2≤ n ≤3000 1≤m≤(n(n-1))/2 1u, v, start n 0≤w≤10 There may be multiple edges between two nodes. Sample Input 56 SL 62 1 2 3 134 4 26 5 22 235 357 1 Sample Output 15 Explanation The graph given in the test case is shown as : Graph • The nodes A.B.C.D and E denote the obvious 1.2.3.4 and 5 node numbers. The starting node is A or 1 (in the given test case) Applying the Prim's algorithm, edge choices available at first are : A->B (WT. 3) and A->C (WT. 4). out of which A->B is chosen (smaller weight of edge). Now the available choices are : A->C (WT. 4). B->C (WT. 5). B->E (WT. 2) and B->D (WT. 6). out of which B->E is chosen by the algorithm. Following the same method of the algorithm, the next chosen edges. sequentially are : A->C and B->D. Hence the overall sequence of edges picked up by prims are : A->B : B->E : A->C : B->D and Total weight of the hence formed MST is : 15
*/

public class Solution_102 {


    class Result {

        /*
         * Complete the 'prims' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY edges
         *  3. INTEGER start
         */

        public static int prims(int n, List<List<Integer>> edges, int start) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (List<Integer> edge : edges) {
                graph.computeIfAbsent(edge.get(0), k -> new ArrayList<>()).add(new int[]{edge.get(1), edge.get(2)});
                graph.computeIfAbsent(edge.get(1), k -> new ArrayList<>()).add(new int[]{edge.get(0), edge.get(2)});
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{start, 0});

            boolean[] visited = new boolean[n + 1];
            int totalWeight = 0;

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentNode = current[0];
                int edgeWeight = current[1];

                if (visited[currentNode]) {
                    continue;
                }

                visited[currentNode] = true;
                totalWeight += edgeWeight;

                if (graph.containsKey(currentNode)) {
                    for (int[] neighbor : graph.get(currentNode)) {
                        if (!visited[neighbor[0]]) {
                            pq.add(new int[]{neighbor[0], neighbor[1]});
                        }
                    }
                }
            }
            return totalWeight;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

            int start = Integer.parseInt(bufferedReader.readLine().trim());

            int result = Result.prims(n, edges, start);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
