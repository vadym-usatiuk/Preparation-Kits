//Sansa and XOR
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
Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays,
followed by XOR-ing the values thus obtained. Determine this value. Example arr = [3,4,5]
Subarray Operation Result 3 None 3 4 None 4 5 None 5 3,4 3 XOR 4 7 4,5 4 XOR 5 1 3,4,5 3 XOR 4 XOR 5 2
Now we take the resultant values and XOR them together. 30405070102 = 6. Return 6.
Function Description Complete the sansaXor function in the editor below. sansaXor has the following parameter(s) :
int arr[n] : an array of integers Returns ⚫int : the result of calculations
Input Format The first line contains an integer t. the number of the test cases.
Each of the next t pairs of lines is as follows : -The first line of each test case contains an integer n,
the number of elements in arr. -The second line of each test case contains a space-separated integers arr[i].
Constraints 15155 2≤ n ≤10 1≤ arri≤10 Sample Input 4575 Sample Output Explanation Test case #00 :
10203 (102) (203) (123) = 2 Test case #01 : 4050705 (45) (57) (705) (457) (575) (40575)=0
*/
class Result_043 {

    /*
     * Complete the 'sansaXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int sansaXor(List<Integer> arr) {
        int n = arr.size();
        if (n % 2 == 0) {
            return 0; // If the number of elements in the array is even, XOR of all subarrays cancels out to 0.
        } else {
            int result = 0;
            for (int i = 0; i < n; i += 2) {
                result ^= arr.get(i); // XOR of elements at even indices
            }
            return result;
        }
    }
}


public class Solution_043 {
    public static void main(String[] args) throws IOException {

        List<Integer> arr = Arrays.asList(4, 5, 7, 5);
        int result = Result_043.sansaXor(arr);
        System.out.println(result); // Output: 0

// BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                int result = Result_043.sansaXor(arr);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

