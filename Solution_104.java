//Floyd : City of Blinding Lights
//O(n*n*n)

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
Given a directed weighted graph where weight indicates distance, for each query, determine the length of the shortest path between nodes. There may be many queries, so efficiency counts. For example, your graph consists of 5 nodes as in the following : 1 2 5 A few queries are from node 4 to node 3, node 2 to node 5, and node 5 to node 3. 1. There are two paths from 4 to 3 : ° • 4 1 2 3 at a distance of 4+5+1=10 • 4 1 53 at a distance of 4+3+2=9 In this case we choose path 2. 2. There is no path from 2 to 5, so we return -1. 3. There is one path from 5 to 3 : 。 53 at a distance of 2. Input Format The first line has two integers n and m. the number of nodes and the number of edges in the graph. Each of the next m lines contains three space-separated integers uv exists, and w, the length of the edge. The next line contains a single integer q. the number of queries. and w. the two nodes between which the directed edge Each of the next q lines contains two space-separated integers a and b, denoting the start and end nodes for traversal.
Constraints 2≤ n ≤400 1≤m≤ 2 1≤q≤105 1≤ u, v≤n 1≤ w≤350 The distance from a node to itself is always 0 and it is always reachable from itself. If there are edges between the same pair of nodes with different weights, the last one (most recent) is to be considered as the only edge between them. Output Format Print q lines, each containing a single integer specifying the shortest distance for the query. If the destination node is not reachable, return -1. Sample Input STDIN Function -------- 45 125 1 4 24 2 4 6 3 4 4 327 33 3 12 31 14 n4, m 5 u = 1, v2, w = 5 u = 1, v 4, w = 24 ... q=3 query : from 1 to 2 query 1 : from 3 to 1 query 2 : from 1 to 4
Sample Output 5 -1 11 Explanation The graph given in the test case is : 24 1 5 2 7 3 The shortest paths for the 3 queries are : • 1⇒ 2 : The direct path is shortest with weight 5 •-1 : There is no way of reaching node 1 from node 3 1⇒2⇒ 4 : The indirect path is shortest with weight (5+6) = 11 units. The direct path is longer with 24 units length.
*/
public class Solution_104 {
    public static void solve(int nodes, List<List<Integer>> input, int q, List<List<Integer>> queries) throws IOException {

//Using Floyd Warshall algorithm

        BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));

        int[][] cost = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < nodes + 1; i++) {
            for (int j = 0; j < nodes + 1; j++) {
                cost[i][j] = Integer.MAX_VALUE;

                if (j == i) {
                    cost[i][j] = 0;
                }

            }
        }

        for (List<Integer> list : input) {
            int startNode = list.get(0);
            int destNode = list.get(1);
            int weight = list.get(2);

            cost[startNode][destNode] = weight;
        }

        for (int k = 1; k < nodes + 1; k++) {
            for (int i = 1; i < nodes + 1; i++) {
                for (int j = 1; j < nodes + 1; j++) {
                    if (cost[i][k] != Integer.MAX_VALUE
                            && cost[k][j] != Integer.MAX_VALUE
                            && cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }

        for (List<Integer> query : queries) {
            int startNode = query.get(0);
            int destNode = query.get(1);

            int lowestWeight = cost[startNode][destNode];

            if (lowestWeight == Integer.MAX_VALUE) lowestWeight = -1;

            writer.write(lowestWeight + "\n");
        }

        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] roadNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int roadNodes = Integer.parseInt(roadNodesEdges[0]);
        int roadEdges = Integer.parseInt(roadNodesEdges[1]);

        List<List<Integer>> input = new ArrayList<>();

        IntStream.range(0, roadEdges).forEach(i -> {
            try {
                String[] roadFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> list = new ArrayList<>();

                list.add(Integer.parseInt(roadFromToWeight[0]));
                list.add(Integer.parseInt(roadFromToWeight[1]));
                list.add(Integer.parseInt(roadFromToWeight[2]));

                input.add(list);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int x = Integer.parseInt(firstMultipleInput[0]);

                int y = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> query = new ArrayList<>();

                query.add(x);
                query.add(y);

                queries.add(query);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        solve(roadNodes, input, q, queries);

        bufferedReader.close();
    }
}

