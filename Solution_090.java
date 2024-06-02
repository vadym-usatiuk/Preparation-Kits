//Mock Test 10 - Almost Sorted
//O(n log n)

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
Given an array of integers, determine whether the array can be sorted in ascending order using only one of the following operations one time. 1. Swap two elements. 2. Reverse one sub-segment. Determine whether one, both or neither of the operations will complete the task. Output is as follows. 1. If the array is already sorted, output yes on the first line. You do not need to output anything else. 2. If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then : • If elements can only be swapped, d[!] and d[r], output swap /r in the second line. I and rare the indices of the elements to be swapped, assuming that the array is indexed from 1 to n. • If elements can only be reversed, for the segment d[l...r], output reverse Irin the second line. I and rare the indices of the first and last elements of the subarray to be reversed, assuming that the array is indexed from 1 to n. Here dl...r] represents the subarray that begins at index and ends at index 7', both inclusive. If an array can be sorted both ways, by using either swap or reverse, choose swap. 3. If the array cannot be sorted either way, output no on the first line. Example arr = [2,3,5,4] Either swap the 4 and 5 at indices 3 and 4, or reverse them to sort the array. As mentioned above, swap is preferred over reverse. Choose swap. On the first line, print yes. On the second line, print swap 3 4. Function Description Complete the almostSorted function in the editor below. almostSorted has the following parameter(s) : ⚫int arr[n] : an array of integers Prints • Print the results as described and return nothing.
Input Format The first line contains a single integer n, the size of arr. The next line contains n space-separated integers arr[i] where 1 ≤i≤n. Constraints 2≤ n ≤100000 0 arr[i] 1000000 All arr[i] are distinct. Output Format 1. If the array is already sorted, output yes on the first line. You do not need to output anything else. 2. If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then : a. If elements can be swapped, d[] and d[r], output swap Ir in the second line. I and r are the indices of the elements to be swapped, assuming that the array is indexed from 1 to n. b. Otherwise, when reversing the segment d[l...r], output reverse I r in the second line. I and r are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from 1 to n. dll...r] represents the sub-sequence of the array, beginning at index l and ending at index r, both inclusive. If an array can be sorted by either swapping or reversing, choose swap. 3. If you cannot sort the array either way, output no on the first line. Sample Input 1 STDIN Function 2 42 arr[] size n = 2 arr =[4,2] Sample Output 1 yes swap 12 Explanation 1 You can either swap(1, 2) or reverse(1, 2). You prefer swap. Sample Input 2 33 312
Explanation 2 It is impossible to sort by one single operation. Sample Input 3 6 15 4 3 26 Sample Output 3 yes reverse 2 5 Explanation 3 You can reverse the sub-array d[2...5]="5432", then the array becomes sorted.
*/
class Solution_090 {
    class Result {

        /*
         * Complete the 'almostSorted' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void almostSorted(List<Integer> arr) {
            int n = arr.size();
            int[] sorted = arr.stream().sorted().mapToInt(Integer::intValue).toArray();
            Integer[] arrArray = arr.toArray(new Integer[0]);

            if (Arrays.equals(arrArray, Arrays.stream(sorted).boxed().toArray(Integer[]::new))) {
                System.out.println("yes");
                return;
            }

            int start = -1;
            int end = -1;
            for (int i = 0; i < n; i++) {
                if (!arr.get(i).equals(sorted[i])) {
                    start = i;
                    break;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (!arr.get(i).equals(sorted[i])) {
                    end = i;
                    break;
                }
            }

            Collections.swap(arr, start, end);
            if (Arrays.equals(arr.toArray(new Integer[0]), Arrays.stream(sorted).boxed().toArray(Integer[]::new))) {
                System.out.println("yes");
                System.out.println("swap " + (start + 1) + " " + (end + 1));
                return;
            }
            Collections.swap(arr, start, end);

            List<Integer> subList = arr.subList(start, end + 1);
            Collections.reverse(subList);
            if (Arrays.equals(arr.toArray(new Integer[0]), Arrays.stream(sorted).boxed().toArray(Integer[]::new))) {
                System.out.println("yes");
                System.out.println("reverse " + (start + 1) + " " + (end + 1));
                return;
            }

            System.out.println("no");
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            Result.almostSorted(arr);

            bufferedReader.close();
        }
    }
}