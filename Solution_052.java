//Sum vs XOR
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
Given an integern, find each such that where denotes the bitwise XOR operator.
Return the number of ar's satisfying the criteria. Example 114 There are four values that meet the criteria :
4+0 4 0-4 4+1 41-5 4+2 4 2 6 4+3 43 7 Return 4. Function Description Complete the sumXor function in the editor below.
sumXor has the following parameters -int nc an integer Returns -Int :
the number of values found Input Format A single integer,
L Constraints 010 Subtasks 0100 for 60% of the maximum score.
Output Format Sample Input 0 Sample Output 0 Explanation 0 For=5,
 the values 0 and 2 satisfy the conditions : 5+0 5, 50-5 5+2 7, 52=7
 Sample Input 1 18 Sample Output 1 Explanation 1 For 10, the values 0, 1, 4, and 5 satisfy the conditions :
 10+0 10, 100 101 10+1 11, 101 11 10+4 14, 104 14 10+5 15, 105=15
*/
class Result_052 {

    /*
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) {
        long zeroBits = 0;

        // Counting the number of zero bits
        while (n > 0) {
            if ((n & 1) == 0) {
                zeroBits++;
            }
            n >>= 1;
        }

        // number of valid 'a' values is 2 to the power of zeroBits
        return 1L << zeroBits;
    }

}

public class Solution_052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result_052.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

