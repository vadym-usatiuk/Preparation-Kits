//Counter game
//O(log n)

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
Louise and Richard have developed a numbers game. They pick a number and check to see if it is a power of 2.
If it is, they divide it by 2. If not, they reduce it by the next lower number which is a power of 2.
Whoever reduces the number to 1 wins the game. Louise always starts. Given an initial value,
determine who wins the game. Example n = 132 It's Louise's turn first. She determines that 132 is not a power of 2.
The next lower power of 2 is 128, so she subtracts that from 132 and passes 4 to Richard. 4 is a power of 2,
so Richard divides it by 2 and passes 2 to Louise. Likewise, 2 is a power so she divides it by 2 and reaches 1.
She wins the game. Update If they initially set counter to 1, Richard wins. Louise cannot make a move so she loses.
Function Description Complete the counterGame function in the editor below. counterGame has the following parameter(s) :
 int n : the initial game counter value Returns string : either Richard or Louise
 Input Format The first line contains an integer, the number of testcases.
 Each of the next t lines contains an integern, the initial value for each game.
 Constraints 1st≤10 1≤ n ≤264-1 Sample Input Sample Output Richard Explanation •
 As 6 is not a power of 2, Louise reduces the largest power of 2 less than 6 i.e., 4,
 and hence the counter reduces to 2. • As 2 is a power of 2, Richard reduces the counter by half of 2 i.e., 1.
 Hence the counter reduces to 1. As we reach the terminating condition with N == 1, Richard wins the game.
*/
class Result_051 {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        int moves = 0;

        // Reduce n to 1
        while (n > 1) {
            // Check if n is a power of 2
            if ((n & (n - 1)) == 0) {
                n /= 2;
            } else {
                n -= Long.highestOneBit(n);
            }
            moves++;
        }

        // Find the winner based on the number of moves
        if (moves % 2 == 0) {
            return "Richard";
        } else {
            return "Louise";
        }
    }
}

public class Solution_051 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result_051.counterGame(n);

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
