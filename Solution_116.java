//Jack goes to Rapture
//Dijkstra's Algorithm  O((gEdges+gNodes)loggNodes)

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
Jack has just moved to a new city called Rapture. He wants to use the public public transport system. The fare rules are as follows : 1. Each pair of connected stations has a fare assigned to it regardless of direction of travel. 2. If Jack travels from station A to station B, he only has to pay the difference between (the fare from A to B) and (the cumulative fare paid to reach station A). [fare(A.B) - total fare to reach station A]. If the difference is negative. travel is free of cost from A to B. Jack is low on cash and needs your help to figure out the most cost efficient way to go from the first station to the last station. Given the number of stations g_nodes (numbered from 1 to g_nodes). and the fares (weights) between the g_edges pairs of stations that are connected, determine the lowest fare from station 1 to station g_nodes. Example g_nodes = 4 g from [1, 1, 2, 3] = g_to= [2,3,4,4] = g_weight [20, 5, 30, 40] The graph looks like this : 2 20 30 1 کا 5 40 4 3. Travel from station 1 →2→4 costs 20 for the first segment (1→ 2) then the cost differential, an additional 30 20 10 for the remainder. The total cost is 30. Travel from station 134 costs 5 for the first segment, then an additional 40-5 = 35 for the remainder, a total cost of 40. The lower priced option costs 30.
Function Description Complete the getCost function in the editor below. getCost has the following parameters : • int g_nodes : the number of stations in the network ⚫ int g_from[g_edges] : end stations of a bidirectional connection int g_to[g_edges] : g_from[i] is connected to g_to[i] at cost g_weight[i] ⚫ int g_weight[g_edges] : the cost of travel between associated stations Prints -int or string : the cost of the lowest priced route from station 1 to station g_nodes or NO PATH EXISTS. No return value is expected. Input Format The first line contains two space-separated integers. g_nodes and g_edges, the number of stations and the number of connections between them. Each of the next g_edges lines contains three space-separated integers. g_from, g_to and g_weight, the connected stations and the fare between them. Constraints • 1g nodes 50000 . 1g edges <500000 1g weight[i] <107
Sample Input 1 Sample Output 1 80 Sample Input 2 Sample Output 2 85 55 1 2 60 35 70 14 120 4 5 150 2380 56 1230 23 50 34 70 4 5 90 13 70 3 5 85 Copy Download Copy Download
*/

public class Solution_116 {

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        long cost;

        public Node(int id, long cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    static class Result {
        public static void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
            List<List<Edge>> graph = new ArrayList<>(gNodes + 1);
            for (int i = 0; i <= gNodes; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < gFrom.size(); i++) {
                int from = gFrom.get(i);
                int to = gTo.get(i);
                int weight = gWeight.get(i);
                graph.get(from).add(new Edge(to, weight));
                graph.get(to).add(new Edge(from, weight));
            }

            long[] dist = new long[gNodes + 1];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[1] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(1, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                int u = current.id;
                long currentCost = current.cost;

                if (currentCost > dist[u]) continue;

                for (Edge edge : graph.get(u)) {
                    int v = edge.to;
                    long newCost = edge.weight;

                    if (currentCost < newCost) {
                        newCost -= currentCost;
                    } else {
                        newCost = 0;
                    }

                    if (dist[u] + newCost < dist[v]) {
                        dist[v] = dist[u] + newCost;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }

            long result = dist[gNodes];
            if (result == Long.MAX_VALUE) {
                System.out.println("NO PATH EXISTS");
            } else {
                System.out.println(result);
            }
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int gNodes = Integer.parseInt(gNodesEdges[0]);
            int gEdges = Integer.parseInt(gNodesEdges[1]);

            List<Integer> gFrom = new ArrayList<>();
            List<Integer> gTo = new ArrayList<>();
            List<Integer> gWeight = new ArrayList<>();

            IntStream.range(0, gEdges).forEach(i -> {
                try {
                    String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                    gFrom.add(Integer.parseInt(gFromToWeight[0]));
                    gTo.add(Integer.parseInt(gFromToWeight[1]));
                    gWeight.add(Integer.parseInt(gFromToWeight[2]));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            Result.getCost(gNodes, gFrom, gTo, gWeight);

            bufferedReader.close();
        }
    }
}
