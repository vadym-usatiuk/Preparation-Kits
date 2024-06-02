//Mock Test 12 - Components in a graph
//O(N⋅A(N))

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
1. Components in a graph There are 2 x N nodes in an undirected graph, and a number of edges connecting some nodes. In each edge, the first value will be between 1 and N, inclusive. The second node will be between N + 1 and 2 x N, inclusive. Given a list of edges, determine the size of the smallest and largest connected components that have 2 or more nodes. A node can have any number of connections. The highest node value will always be connected to at least 1 other node. Note Single nodes should not be considered in the answer. Example bg = [[1,5], [1,6], [2,4]] 3 3 2 4 1 5 6 The smaller component contains 2 nodes and the larger contains 3. Return the array [2,3]. Function Description Complete the connected Components function in the editor below. connected Components has the following parameter(s) : -int bg[n][2] : a 2-d array of integers that represent node ends of graph edges Returns - int[2] : an array with 2 integers, the smallest and largest component sizes Input Format The first line contains an integer n, the size of bg. Each of the next n lines contain two space-separated integers, bg[i][0] and bg[i][1]. Constraints 1≤numberofnodes N <15000 ⚫1≤bg[i][0] ≤ N • N+1bg[i][1] <2N
Sample Input STDIN Function 512342 16 27 38 49 26 bg] size n = 5 bg [[1, 6], [2, 7], [3, 8], [4,9], [2, 6]] = Sample Output 24 Explanation 5 4 3 نیا 8 1 6 2 7 Since the component with node 5 contains only one node, it is not considered. The number of vertices in the smallest connected component in the graph is 2 based on either (3,8) or (4,9). The number of vertices in the largest connected component in the graph is 4 i.e. 1-2-6-7.
*/

public class Solution_108 {
    class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (size[rootP] < size[rootQ]) {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                } else {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                }
            }
        }

        public int getSize(int p) {
            return size[find(p)];
        }
    }

    class Result {

        /*
         * Complete the 'componentsInGraph' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts 2D_INTEGER_ARRAY gb as parameter.
         */

        public List<Integer> componentsInGraph(List<List<Integer>> gb) {
            int maxNode = 0;
            for (List<Integer> edge : gb) {
                maxNode = Math.max(maxNode, Math.max(edge.get(0), edge.get(1)));
            }

            UnionFind uf = new UnionFind(maxNode);
            for (List<Integer> edge : gb) {
                uf.union(edge.get(0), edge.get(1));
            }

            int minComponentSize = Integer.MAX_VALUE;
            int maxComponentSize = Integer.MIN_VALUE;
            Map<Integer, Integer> componentSizeMap = new HashMap<>();

            for (int i = 1; i <= maxNode; i++) {
                int root = uf.find(i);
                componentSizeMap.put(root, componentSizeMap.getOrDefault(root, 0) + 1);
            }

            for (int size : componentSizeMap.values()) {
                if (size > 1) {
                    minComponentSize = Math.min(minComponentSize, size);
                    maxComponentSize = Math.max(maxComponentSize, size);
                }
            }

            return Arrays.asList(minComponentSize, maxComponentSize);
        }

    }
}

