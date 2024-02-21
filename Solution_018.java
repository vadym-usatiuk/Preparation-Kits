//Permuting Two Arrays
//Time complexity is O(n log n)

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
There are two W-element arrays of integers, A and B.
Permute them into some A' and B' such that the relation A'[]+B[i]>k holds for all where 0 ≤i<n.
will be a queries consisting of A, B, and k. For each query,
return YES if some permutation A'. B' satisfying the relation exists. Otherwise, return NO.
There Example A = [0, 1] B = [0,2] k=1 A valid A', B' is A' = [1,0] and B = [0, 2] : 1+021 and 0+2 2 1.
Return YES. Function Description Complete the twoArrays function in the editor below.
It should return a string, either YES or NO. twoArrays has the following parameter(s) :
int k : an integer int A[n] : an array of integers int B[n] : an array of integers . .
Returns -string : either YES or NO Input Format The first line contains an integer q. the number of queries.
The next g sets of 3 lines are as follows : •
The first line contains two space-separated integers and A, the size of both arrays A and B.
and the relation variable. • The second line contains # space-separated integers A[i]. .
The third line contains Wspace-separated integers B[i].
Constraints • 1 ≤ q ≤ 10 . 1≤n≤ 1000 . 1≤k≤ 10⁰ •0 < Ali, B[i| < 10 Sample Input STDIN 2 3 10 213 789 45 1221 33 34
Sample Output YES NO Function 9-2 A[] and B[] size n 3, k - 10 A [2, 1, 3) B (7, 8, 9] A[] and
B[] size n 4, k-5 A [1, 2, 2, 1) B [3, 3, 3, 4)
Explanation There are two queries : 1. Permute these into A' = [1,2,3] and B = [9, 8, 7]
so that the following statements are true :
A[0] + B[1] = 1+9= 102 k A[1] + B[1] = 2 + 8 = 10 ≥ k A[2] + B[2] =3+7= 102 k 2.
A = [1, 2, 2, 1], B = [3, 3, 3, 4], and k = 5.
To permute A and B into a valid A' and B', there must be at least three numbers in A that are greater than 1. 0 0
*/
class Result_018 {

    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // sort arrays A and B
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());

        // need to check if the sum of corresponding elements satisfies the condition
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }

        return "YES";
    }


}


public class Solution_018 {
    public static void main(String[] args) throws IOException {

        // Test cases
        List<Integer> A1 = Arrays.asList(2, 1, 3);
        List<Integer> B1 = Arrays.asList(7, 8, 9);
        System.out.println(Result_018.twoArrays(10, A1, B1)); // Expected output: YES

        List<Integer> A2 = Arrays.asList(1, 2, 2, 1);
        List<Integer> B2 = Arrays.asList(3, 3, 3, 4);
        System.out.println(Result_018.twoArrays(5, A2, B2)); // Expected output: NO


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int n = Integer.parseInt(firstMultipleInput[0]);
//
//                int k = Integer.parseInt(firstMultipleInput[1]);
//
//                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                String result = Result_018.twoArrays(k, A, B);
//
//                bufferedWriter.write(result);
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