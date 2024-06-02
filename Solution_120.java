//Mock Test 13 - Subset Component
//O(2 power of n * n power of 2)

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
2. Subset Component You are given an array with n 64-bit integers : d[0],d[1],...,d[n-1]. BIT(x, i) = (x >> i) & 1, where B(x, z) is the ith lower bit of a in binary form. If we regard every bit as a vertex of a graph G, there is an undirected edge between vertices ; and j if there is a value k such that BIT(d[k], 1) == 1 && BIT(d[k], j) == 1. For every subset of the input array, how many connected-components are there in that graph? A connected component in a graph is a set of nodes which are accessible to each other via a path of edges. There may be multiple connected components in a graph. Example d = {1,2,3,5} In the real challenge, there will be 64 nodes associated with each integer in d represented as a 64 bit binary value. For clarity, only 4 bits will be shown in the example but all 64 will be considered in the calculations. Decimal Binary Edges Node ends d[0] = 1 0001 0 d[1] = 2 0010 0 d[2] = 3 0011 1 e and 1 d[3] = 5 0101 1 Ⓒ and 2 Consider all subsets : Edges Subset Count Nodes Connected components {1} 0 64 {2} 0 64 {3} 1 0-1 63 {5} 1 0-2 63 {1,2} 0 64 {1,3} 1 0-1 63 {1,5} 1 0-2 63 {2,3} 1 0-1 63 {2,5} {3,5} {1,2,3} {1,2,5} {1,3,5} {2,3,5} {1,2,3,5} Sum 121 0-2 63 0-1-2 62 0-1 63 H222 1 0-2 63 0-1-2 0-1-2 33 62 62 0-1-2 62 944
The values 3 and 5 have 2 bits set, so they have 1 edge each. If a subset contains only a 3 or 5, there will be one connected component with 2 nodes, and 62 components with 1 node for a total of 63. If both 3 and 5 are in a subset, 1 component with nodes 0, 1 and 2 is formed since node 0 is one end of each edge described. The other 61 nodes are solitary, so there are 62 connected components total. All other values have only 1 bit set, so they have no edges. They have 64 components with 1 node each. Function Description Complete the findConnected Components function in the editor below. findConnectedComponents has the following parameters : int d[n] : an array of integers Returns ⚫int : the sum of the number of connected components for all subsets of d Input Format The first row contains the integer n, the size of d[]. The next row has n space-separated integers, d[i]. Constraints 1≤ n ≤20 0≤d[i] <263-1 Sample Input 0 3 259 Sample Output 0 504
Explanation 0 There are 8 subset of {2,5,9}. 0 =>We don't have any number in this subset => no edge in the graph => Every node is a component by itself => Number of connected-components = 64. {2} => The Binary Representation of 2 is 00000010. There is a bit at only one position. => So there is no edge in the graph, every node is a connected-component by itself => Number of connected-components = 64. {5} => The Binary Representation of 5 is 00000101. There is a bit at the 0th and 2nd position. => So there is an edge : (0, 2) in the graph => There is one component with a pair of nodes (0,2) in the graph. Apart from that, all remaining 62 vertices are indepenent components of one node each (1,3,4,5,6...63) => Number of connected- components = 63. {9} => The Binary Representation of 9 is 00001001. => There is a 1-bit at the 0th and 3rd position in this binary representation.=> edge : (0, 3) in the graph => Number of components = 63 {2,5} => This will contain the edge (0, 2) in the graph which will form one component => Other nodes are all independent components => Number of connected-component = 63 {2.9} => This has edge (0,3) in the graph => Similar to examples above, this has 63 connected components (5.9} => This has edges (0, 2) and (0, 3) in the graph => Similar to examples above, this has 62 connected components {2,5,9} => This has edges(0, 2) (0,3) in the graph. All three vertices (0,2,3) make one component => Other 61 vertices are all independent components => Number of connected-components = 62 S 64+64 +63 +63 +63 +63 +62 +62=504
*/

public class Solution_120 {

    class Result {

        /*
         * Complete the 'findConnectedComponents' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts LONG_INTEGER_ARRAY d as parameter.
         */

        public static int findConnectedComponents(List<Long> data) {
            int size = data.size();
            int totalSubsets = 1 << size;
            int totalComponents = 0;

            for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
                List<Long> currentSubset = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    int mask = 1 << j;
                    if ((subsetMask & mask) != 0) {
                        Long element = data.get(j);
                        if (countBits(element) > 1) {
                            Iterator<Long> it = currentSubset.iterator();
                            while (it.hasNext()) {
                                long subsetElement = it.next();
                                if ((subsetElement & element) != 0) {
                                    element |= subsetElement;
                                    it.remove();
                                }
                            }
                            currentSubset.add(element);
                        }
                    }
                }
                int currentSize = currentSubset.size();
                long mergedElements = 0;
                for (long subsetElement : currentSubset) {
                    mergedElements |= subsetElement;
                }
                totalComponents += 64 - countBits(mergedElements) + currentSize;
            }
            return totalComponents;
        }

        private static int countBits(long number) {
            int bitCount = 0;
            while (number != 0) {
                bitCount += (number & 1);
                number >>= 1;
            }
            return bitCount;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int dCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Long> d = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Long::parseLong)
                    .collect(toList());

            int components = Result.findConnectedComponents(d);

            bufferedWriter.write(String.valueOf(components));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
