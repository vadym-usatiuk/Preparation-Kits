//Sherlock and Array
//O(n)

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum
of all elements to the left is equal to the sum of all elements to the right. Example arr = [5,6,8,11] 8 is between
two subarrays that sum to 11. arr = [1] The answer is [1] since left and right sum to 0. You will be given
arrays of integers and must determine whether there is an element that meets the criterion. If there is, return YES.
Otherwise, return NO. Function Description Complete the balancedSums function in the editor below.
balancedSums has the following parameter(s) : int arr[n] : an array of integers Returns string :
either YES or NO Input Format The first line contains T, the number of test cases.
The next 2 pairs of lines each represent a test case. -The first line contains w,
the number of elements in the array arr. The second line contains n space-separated integers arr[i] where 0<i<n.
Constraints 1≤T≤10 1≤ n ≤10 1≤ arr[i] ≤2 x 10' Sample Input 2 4 1233 Sample Output NO YES
Explanation For the first test case, no such index exists. For the second test case, A[0] + A[1] =A[3],
therefore index 2 satisfies the given conditions.
*/
class Result_046 {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (leftSum == totalSum - leftSum - arr.get(i)) {
                return "YES";
            }
            leftSum += arr.get(i);
        }

        return "NO";
    }

}

public class Solution_046 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result_046.balancedSums(arr);

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


