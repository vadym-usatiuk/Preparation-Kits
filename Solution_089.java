//Mock Test 10 - Pairs
//O(n)

/*
Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value. Example k=1 arr = [1,2,3,4] = There are three values that differ by k 1 : 2 11.3-2 = 1, and 4-3=1. Return 3. Function Description Complete the pairs function below. pairs has the following parameter(s) : ⚫int k : an integer, the target difference int arr[n] : an array of integers Returns ⚫int : the number of pairs that satisfy the criterion Input Format The first line contains two space-separated integers n and k, the size of arr and the target value. The second line contains n space-separated integers of the array arr. Constraints ⚫ 2≤ n ≤ 105 ⚫ 0 < k < 10° ⚫0<arr[i] <231-1 ⚫ each integer arr[i] will be unique Sample Input STDIN Function 52 15342 arr[] size n = 5, k =2 arr [1, 5, 3, 4, 2] Sample Output 3 Explanation There are 3 pairs of integers in the set with a difference of 2 : [5,3], [4,2] and [3.1]..
*/

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result_089 {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (set.contains(num + k)) {
                count++;
            }
        }
        return count;
    }
}

public class Solution_089 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_089.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

