//Merging Communities
//O(n) and  O(A(n))

import java.io.*;
import java.util.*;

/*
People connect with each other in a social network. A connection between Person i and Person j is represented as Mij. When two persons belonging to different communities connect, the net effect is the merge the communities which i and j belong to. At the beginning, there are n people representing n communities. Suppose person 1 and 2 connected and later 2 and 3 connected. then 1.2, and 3 will belong to the same community. There are two types of queries : 1. Mij communities containing persons i and j are merged if they belong to different communities. 2. Qi print the size of the community to which person i belongs. Input Format The first line of input contains 2 space-separated integers n and q. the number of people and the number of queries. The next q lines will contain the queries. Constraints 1≤ n ≤105 1≤q≤2 × 105 Output Format The output of the queries. Sample Input STDIN Function ----- - 36 n = 3.q6Q 1 print the size of the community containing person 1 M 12 merge the communities containing persons 1 and 2 ... Q2M 23 Q3 Q2 Sample Output 1233 3 Explanation Initial size of each of the community is 1.
*/

public class Solution_106 {

    public class Solution {

        static class DisjointSetUnion {
            private int[] parent;
            private int[] size;

            public DisjointSetUnion(int n) {
                parent = new int[n + 1];
                size = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int u) {
                if (parent[u] != u) {
                    parent[u] = find(parent[u]);
                }
                return parent[u];
            }

            public void union(int u, int v) {
                int rootU = find(u);
                int rootV = find(v);
                if (rootU != rootV) {
                    if (size[rootU] < size[rootV]) {
                        int temp = rootU;
                        rootU = rootV;
                        rootV = temp;
                    }
                    parent[rootV] = rootU;
                    size[rootU] += size[rootV];
                }
            }

            public int getSize(int u) {
                return size[find(u)];
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            DisjointSetUnion dsu = new DisjointSetUnion(n);
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < q; i++) {
                String query = scanner.next();
                if (query.equals("M")) {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    dsu.union(u, v);
                } else if (query.equals("Q")) {
                    int u = scanner.nextInt();
                    output.append(dsu.getSize(u)).append("\n");
                }
            }
            System.out.print(output);
            scanner.close();
        }
    }
}
