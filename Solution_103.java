//Bead Ornaments
//O(n*m)

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
There are N colors of beads. You have b; beads of the ith color. You want to make an ornament by joining all the beads together. You create the ornament by using the following algorithm : • Step #1 Arrange all the beads in any order such that beads of the same color are placed together. • Step #2 The ornament initially consists of only the first bead from the arrangement. • Step #3 For each subsequent bead in order, join it to a bead of the same color in the ornament. If there is no bead of the same color, it can be joined to any bead in the ornament. All beads are distinct, even if they have the same color. Two ornaments are considered different if two beads are joined by a thread in one configuration, but not in the other. How many different ornaments can be formed using this algorithm? Return the answer modulo (109 +7). Update/clarification Think of the bead formation as a tree and not as a straight line. Any number of beads can be connected to a bead. Example b= [2] There are two beads of color a : al and a2. These can occur as a1, a2 or a2, a1. In both cases, the same two beads are joined. so the arrangements are not different. There is 1 way to join these beads. b= [2,2] There are two beads of two colors, a1, a2, 61, 62. They can be arranged as a1, a2. a2, al, b1, b2 and 62, 61. Call these groups A1, A2, B1 and B2. The 8 possible arranements of groups are shown below. 1 A1, B1a1, a2, b1, b2 2 A2, B1 = a2, al, b1, b2 3 A1, B2 al, a2, b2, b1 4 A2, B2 a2, al, b2, b1 5 B1, A1 = b1, b2, al, a2 6 B2, A1 b2, bl, a1, a2 7 B1, A2 b1, b2, a2, al 8 B2, A2 = b2, b1, a2, al Note that in line 1. (a1, a2). (a2, b1) and (b1, b2) are the connections. This also occurs on line 8, so these two lines are not different. In fact, line 8 is just line 1 reversed, like flipping the string of beads end for end. Using the same logic, the other similar lines are (2,6), (3,7), (4, 5). There are only 4 different arrangements.
Function Description Complete the beadOrnaments function in the editor below. beadOrnaments has the following parameters : ⚫ int b[n] : the number of beads of each color Returns ⚫int : the number of arrangements modulo (109 +7) Input Format The first line contains the number of test cases T. Each of the following T pairs of lines contain : -An integer, n, the number of elements in array b -n space-separated integers that comprise b Constraints • 1 <= T <= 20 . 1<n<= 10 • 1 <= b[i] <= 30 Sample Input STDIN 5222 2 1 22 1 4 23 31 5 1 1 1 1 1 Function T = 5 b[] size n = 2 b = [2,1] n = 2 b = [2, 2] n = 1 b = [4] n = 2 b = [3, 1] n = 5 b[1, 1, 1, 1, 1] Sample Output 2 4 24 16 9 125 Explanation Testcase 1 : Let us label the beads A1,A2 and B1. Initially, they can be arranged in 4 ways - "A1,A2, B1". "A2,A1,B1", "B1,A1,A2", and "B1.A2.A1". For each of the first two arrangements, an ornament can be formed in 2 ways (A1-A2-B1 or B1-A1-A2 from the first one and A2-A1-B1 or B1-A2-A1 from the second one). For each of the last two arrangements, an ornament can be formed in 1 way. However, of the total 6 possible ornaments, there are only 2 unique ones : A1 - A2 - B1, and A2 - A1 - B1. Testcase 2 : The possible unique ornaments are A1 - A2 - B1-B2. A1-A2 -B2 -B1, A2 - A1 -B1 -B2, and A2 - A1-B2 -B1. Testcase 3 : For the third test-case, it might be easier to see there are only 2 types of graphs on 4 vertices : the path or the star. It's not hard to see that there are 12 paths and 4 stars (explanation courtesy : zlangley) Testcase 5 : For the fifth test-case, a lot of people claimed that the total number of possible ways is 5!/2 = 60. But that is wrong. The correct answer is 125. Here's the hint : Once again, you've to think of it as a tree. So one possible arrangement can be : A is a root node and has two edges (A-B and A-C). Now, think of B as a sub-root node with two edges (B-D and B-E). Similarly. you can figure out the other possible bead arrangements. This will lead you to the correct answer.
*/

public class Solution_103 {

    class Result {

        /*
         * Complete the 'beadOrnaments' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY b as parameter.
         */
        private static final long MOD = 1000000007;

        public static long power(long a, int pow) {
            long res = a % MOD;
            int count = 1;

            while (count < pow) {
                res = (res * a) % MOD;
                count++;
            }
            if (pow == 0) {
                return 1;
            }

            return res;
        }

        public static int beadOrnaments(List<Integer> b) {
            int n = b.size();

            long sum = 0;
            long trees = 1;

            for (Integer i : b) {
                sum = (sum + i) % MOD;
                trees = (trees * power(i, i - 2 + 1)) % MOD;
            }

            if (n >= 2) {

                trees = (trees * power(sum, n - 2)) % MOD;
            } else {
                trees = (long) Math.floor(trees / sum);
            }

            return (int) (trees % MOD);
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int bCount = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());

                    int result = Result.beadOrnaments(b);

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
