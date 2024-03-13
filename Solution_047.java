//Misère Nim
//O(n)

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
Two people are playing game of Misère Nim. The basic rules for this game are as follows : .
The game starts with piles of stones indexed from 0 to -1. Each pile (where 0 <i<n) has &; stones.
The players move in alternating turns. During each move,
the current player must remove one or more stones from a single pile.
The player who removes the last stone loses the game. Given the value of and the number of stones in each pille,
determine whether the person who wins the game is the first or second person to move. If the first player to move wins,
print First on a new line; otherwise, print Second. Assume both players move optimally.
Example 8 = [1,1,1] In this case, player 1 picks a pile, player 2 picks a pile and player 1 has to choose the last pile.
Player 2 wins so return Second. 8 = [1,2,2] There is no permutation of optimal moves where player 2 wins. For example,
player 1 chooses the first pile. If player 2 chooses 1 from another pile, player 1 will choose the pile with 2 left.
If player 2 chooses a pile of 2. player 1 chooses 1 from the remaining pile leaving the last stone for player 2.
Return First. Function Description Complete the misereNim function in the editor below. misereNim has the
 following parameters :
 int s[n] : the number of stones in each pile Returns string : either First or Second
 Input Format The first line contains an integer,
 T. the number of test cases. Each test case is described over two lines : 1. An integer, w, the number of piles.
 2. n space-separated integers, a[i], that describe the number of stones at pile .
 Constraints .1≤T≤100 . 1≤ n ≤100 1810 Sample Input STDIN
 Function s[] size n 2 2 T-2 2 11 s [1, 1] 3 213 s] size n 3 s-[2, 1, 3]
 Sample Output First Second Explanation In the first testcase,
 the first player removes 1 stone from the first pile and then the second player has no moves other than
 removing the only stone in the second pile. So first wins. In the second testcase,
 the series of moves can be depicted as :
*/
class Result_048 {

    /*
     * Complete the 'misereNim' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY s as parameter.
     */

//    public static String misereNim(List<Integer> s) {
//        int totalXor = 0;
//        int countOnes = 0;
//
//        for (int stones : s) {
//            totalXor ^= stones;
//            if (stones == 1) {
//                countOnes++;
//            }
//        }
//        if (totalXor == 0) {
//            return (countOnes == s.size() && s.size() % 2 == 1) ? "First" : "Second";
//        } else {
//            return "First";
//        }
//    }

    public static String misereNim(List<Integer> s) {
        if(s.size() - ((int) s.stream().filter(x -> x==1).count()) == 0) {
            if(s.size() %2 ==0) {
                return "First";
            } else {
                return "Second";
            }
        }
        if(s.stream().reduce((x,y) -> x^y).get() == 0) {
            return "Second";
        } else {
            return "First";
        }
    }
}

public class Solution_047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result_048.misereNim(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

