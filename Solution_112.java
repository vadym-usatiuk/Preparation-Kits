//Roads and Libraries
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
Determine the minimum cost to provide library access to all citizens of HackerLand. There are n cities numbered from 1 to n. Currently there are no libraries and the cities are not connected. Bidirectional roads may be built between any city pair listed in cities. A citizen has access to a library if : • Their city contains a library. They can travel by road from their city to a city containing a library. Example The following figure is a sample map of HackerLand where the dotted lines denote possible roads : c_road = 2 c_lib=3 cities = [[1,7], [1,3], [1, 2], [2, 3], [5, 6], [6,8]] The cost of building any road is cc_road = 2, and the cost to build a library in any city is c_lib = 3. Build 5 roads at a cost of 5 x 2 = 10 and 2 libraries for a cost of 6. One of the available roads in the cycle 1 →2→31 is not necessary. There are a queries, where each query consists of a map of HackerLand and value of e lib and c road. For each query, find the minimum cost to make libraries accessible to all the citizens. Function Description Complete the function roadsAnd Libraries in the editor below. roadsAndLibraries has the following parameters : int n : integer, the number of cities ⚫int c_lib : integer, the cost to build a library int c_road : integer, the cost to repair a road ⚫int cities[m][2] : each cities[i] contains two integers that represent cities that can be connected by a new road Returns -int : the minimal cost
Input Format The first line contains a single integer q. that denotes the number of queries. The subsequent lines describe each query in the following format : -The first line contains four space-separated integers that describe the respective values of n. m. c_lib and c road. the number of cities, number of roads, cost of a library and cost of a road. -Each of the next m lines contains two space-separated integers, u[i] and v[i], that describe a bidirectional road that can be built to connect cities u[i] and v[i]. Constraints 1≤q≤10 ⚫ 1≤ n ≤105 • 0≤m≤ min (10³, n-(n-1)) . 1c road, e lib≤ 105 • 1 < u[i], v[i] < n • Each road connects two distinct cities. Sample Input STDIN Function 2 3 3 2 1 q=2 n = 3, cities [] size m = 3, c_lib = 2, c_road = 1 cities = [[1, 2], [3, 1], [2, 3]] 12 3 1 23 6625 13 34 24 12 23 56 n = 6, cities [] size m = 6, c_lib = 2, c_road = 5 cities [[1, 3], [3, 4],...]
Sample Output 12 Explanation Perform the following g = 2 queries : 1. HackerLand contains n = 3 cities and can be connected by m = 3 bidirectional roads. The price of building a library is c = 2 and the price for repairing a road is Croad = 1. Library The cheapest way to make libraries accessible to all is to : • Build a library in city 1 at a cost of a = 2. • Build the road between cities 1 and 2 at a cost of y = 1. • Build the road between cities 2 and 3 at a cost of y = 1. This gives a total cost of 2+1+1=4. Note that the road between cities 3 and 1 does not need to be built because each is connected to city 2. 2. In this scenario it is optimal to build a library in each city because the cost to build a library is less than the cost to build a road. Library Library Library Library Library Library There are 6 cities, so the total cost is 6 x 2 = 12.
*/

public class Solution_112 {
    class Result {

        /*
         * Complete the 'roadsAndLibraries' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER c_lib
         *  3. INTEGER c_road
         *  4. 2D_INTEGER_ARRAY cities
         */

        public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
            if (c_lib <= c_road) {
                return (long) n * c_lib;
            }

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (List<Integer> city : cities) {
                int u = city.get(0);
                int v = city.get(1);
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            boolean[] visited = new boolean[n + 1];
            long totalCost = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    long componentSize = dfs(i, adjList, visited);
                    totalCost += c_lib + (componentSize - 1) * c_road;
                }
            }

            return totalCost;
        }

        private static long dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
            Stack<Integer> stack = new Stack<>();
            stack.push(node);
            visited[node] = true;
            long size = 0;

            while (!stack.isEmpty()) {
                int current = stack.pop();
                size++;
                for (int neighbor : adjList.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(neighbor);
                    }
                }
            }

            return size;
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

                    int c_lib = Integer.parseInt(firstMultipleInput[2]);

                    int c_road = Integer.parseInt(firstMultipleInput[3]);

                    List<List<Integer>> cities = new ArrayList<>();

                    IntStream.range(0, m).forEach(i -> {
                        try {
                            cities.add(
                                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                            .map(Integer::parseInt)
                                            .collect(toList())
                            );
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });

                    long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
