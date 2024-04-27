//Jesse and Cookies
//O(n log n)

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
Jesse loves cookies and wants the sweetness of some cookies to be greater than value k. To do this, two cookies with the least sweetness are repeatedly mixed. This creates a special combined cookie with : sweetness = (1x Least sweet cookie + 2x 2nd least sweet cookie). This occurs until all the cookies have a sweetness ≥ k. Given the sweetness of a number of cookies, determine the minimum number of operations required. If it is not possible, return -1. Example k=9 A = [2,7,3,6,4,6] The smallest values are 2, 3. Remove them then return 2+2 x 3 = 8 to the array. Now A = [8,7, 6, 4, 6]. Remove 4, 6 and return 4+6 x 2 = 16 to the array. Now A = [16,8,7,6]. Remove 6, 7. return 6+2 x7 = 20 and A = [20, 16, 8, 7]. Finally, remove 8,7 and return 7+ 2 x 8 = 23 to A. Now A = [23, 20, 16]. All values are ≥ k = 9 so the process stops after 4 iterations. Return 4. Function Description Complete the cookies function in the editor below. cookies has the following parameters : ⚫int k : the threshold value ⚫ int a[n] : an array of sweetness values Returns ⚫int : the number of iterations required or -1 Input Format The first line has two space-separated integers, n and k, the size of A] and the minimum required sweetness respectively. The next line contains n space-separated integers. A[i]. Constraints 1≤ n ≤106 0≤ k ≤ 10º 0≤ A[i] <10%
Sample Input STDIN 67 Function A[] size n = 6, k = 7 1 2 3 9 10 12 A = [1, 2, 3, 9, 10, 12] Sample Output 2 Explanation Combine the first two cookies to create a cookie with sweetness = 1x1+2×2=5 After this operation, the cookies are 3, 5, 9, 10, 12. Then, combine the cookies with sweetness 3 and sweetness 5, to create a cookie with resulting sweetness = 1 x 3+2 x 5 = 13 Now, the cookies are 9, 10, 12, 13. All the cookies have a sweetness > 7. Thus, 2 operations are required to increase the sweetness.
*/

class Result_086 {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int operations = 0;

        while (pq.size() > 1 && pq.peek() < k) {
            int first = pq.poll();
            int second = pq.poll();
            int combinedSweetness = first + (2 * second);
            pq.offer(combinedSweetness);
            operations++;
        }

        return pq.peek() >= k ? operations : -1;
    }
}

public class Solution_086 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_086.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

