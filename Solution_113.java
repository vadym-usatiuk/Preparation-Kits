//Journey to the Moon
//O(n+p)

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
The member states of the UN are planning to send 2 people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from. Example astronaut = [1,2], [2,3] There are 4 astronauts numbered through 3. Astronauts grouped by country are [0] and [1,2,3]. There are 3 pairs to choose from : [0,1], [0,2] and [0,3]. Function Description Complete the journeyToMoon function in the editor below. journeyToMoon has the following parameter(s) : int no the number of astronauts ⚫int astronautip[2] : each element astronauti] is a 2 element array that represents the ID's of two astronauts from the same country Returns -int : the number of valid pairs Input Format The first line contains two integers and p. the number of astronauts and the number of pairs. Each of the next lines contains 2 space-separated integers denoting astronaut ID's of two who share the same nationality. Constraints 15P≤ 10 Sample Input ONOU 313 01 23 04 Sample Output Explanation Persons numbered 0,1 and 4 belong to the same country, and those numbered 2 and 3 belong to the same country, but different from the previous one. All in all, the UN has 6 ways of choosing a pair : 1. persons 0 and 2 2. persons and 3 3. persons 1 and 2 4. persons 1 and 3 5. persons 2 and 4 6. persons 3 and 4
*/

public class Solution_113 {

    class Result {

        /*
         * Complete the 'journeyToMoon' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY astronaut
         */
        public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (List<Integer> pair : astronaut) {
                int u = pair.get(0);
                int v = pair.get(1);
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }

            boolean[] visited = new boolean[n];
            List<Integer> countrySizes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int countrySize = dfs(i, adjList, visited);
                    countrySizes.add(countrySize);
                }
            }

            long totalPairs = (long) n * (n - 1) / 2;
            long sameCountryPairs = 0;
            for (int size : countrySizes) {
                sameCountryPairs += (long) size * (size - 1) / 2;
            }

            return totalPairs - sameCountryPairs;
        }

        private static int dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
            Stack<Integer> stack = new Stack<>();
            stack.push(node);
            visited[node] = true;
            int size = 0;

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

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);
            int p = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> astronaut = new ArrayList<>();

            IntStream.range(0, p).forEach(i -> {
                try {
                    astronaut.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            long result = Result.journeyToMoon(n, astronaut); // Change int to long

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}