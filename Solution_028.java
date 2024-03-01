//Left Rotation
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
A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
Given an integer, d, rotate the array that many steps left and return the result.
Example d=2 arr = [1, 2, 3, 4, 5] After 2 rotations, arr' = [3, 4, 5, 1, 2].
Function Description Complete the rotateLeft function in the editor below. rotateLeft has the following parameters
 • int d : the amount to rotate by • int arr[n] : the array to rotate Returns • int[n] : the rotated array
 Input Format The first line contains two space-separated integers that denote, the number of integers, and d,
 the number of left rotations to perform. The second line contains n space-separated integers that describe
 arr Constraints • 1 ≤ n ≤ 10³ • 1≤d≤n • 1 ≤ a[i] ≤ 10° Sample Input 54 12345 Sample Output 51234
 Explanation To perform d = 4 left rotations, the array undergoes the following sequence of changes :
 [1, 2, 3, 4, 5] → [2, 3, 4, 5, 1] → [3, 4, 5, 1, 2] → [4, 5, 1, 2, 3] → [5, 1, 2, 3, 4]
*/
class Result_028 {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        List<Integer> rotated = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            int newIndex = (i - d + n) % n;
            rotated.set(newIndex, arr.get(i));
        }

        return rotated;
    }

}

public class Solution_028 {
    public static void main(String[] args) throws IOException {
        // Test cases
        List<Integer> arr1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result1 = Result_028.rotateLeft(2, arr1);
        System.out.println("Result 1: " + result1); // Output: [3, 4, 5, 1, 2]

        List<Integer> arr2 = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> result2 = Result_028.rotateLeft(3, arr2);
        System.out.println("Result 2: " + result2); // Output: [2, 1, 5, 4, 3]

        List<Integer> arr3 = Arrays.asList(7, 8, 9, 10, 11, 12);
        List<Integer> result3 = Result_028.rotateLeft(1, arr3);
        System.out.println("Result 3: " + result3); // Output: [8, 9, 10, 11, 12, 7]

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int n = Integer.parseInt(firstMultipleInput[0]);
//
//        int d = Integer.parseInt(firstMultipleInput[1]);
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result_028.rotateLeft(d, arr);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

