//Find the Running Median
//O(nlog n)

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
The median of a set of integers is the midpoint value of the data set for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your set of integers in non-decreasing order, then : If your set contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted set {1,2,3}. 2 is the median. If your set contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted set {1, 2, 3, 4}. 2+3 = 2.5 is the median. Given an input stream of n integers, perform the following task for each th integer : 1. Add the ith integer to a running list of integers. 2. Find the median of the updated list (i.e.. for the first element through the ith element). 3. Print the updated median on a new line. The printed value must be a double-precision number scaled to 1 decimal place (i.e.. 12.3 format). Example a = [7,3,5,2] Sorted Median [7] [3, 7] 7.0 5.0 [3, 5, 7] 5.0 [2, 3, 5, 7] 4.0 Each of the median values is stored in an array and the array is returned for the main function to print. Note : Add formatting to the print statement. Function Description Complete the runningMedian function in the editor below. runningMedian has the following parameters : -int a[n] : an array of integers Returns -float[n] : the median of the array after each insertion, modify the print statement in main to get proper formatting. Input Format The first line contains a single integer, n. the number of integers in the data stream. Each line of the n subsequent lines contains an integer, a[i], to be inserted into the list.
Input The first line contains a single integer, n, the number of integers in the data stream. Each line i of the n subsequent lines contains an integer, a[i], to be inserted into the list. Constraints 1≤ n ≤105 ⚫0≤a[i] ≤105 Sample Input STDIN Function 6 12 a[] size n = 6 a [12, 4, 5, 3, 8, 7] 7 453 8T Sample Output 12.0 8.0 5.0 4.5 5.0 6.0 Explanation There are n = 6 integers, so we must print the new median on a new line as each integer is added to the list : 1. list {12}, median = 12.0 = 2. list={4, 12}, median = 4+12 = 8.0 3.list= {4, 5, 12), median = 5.0 4. list = {3,4,5,12}, median = 4+5 = 4.5 = 5. list {3,4,5,8, 12), median = 5.0 6. list = {3, 4, 5, 7, 8, 12), median = 5+7 = 6.0
*/

public class Solution_110 {
    static class Result {
        public static List<Double> runningMedian(List<Integer> a) {
            List<Double> medians = new ArrayList<>();
            PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> upper = new PriorityQueue<>();

            for (int num : a) {
                if (lower.isEmpty() || num <= lower.peek()) {
                    lower.offer(num);
                } else {
                    upper.offer(num);
                }

                if (lower.size() > upper.size() + 1) {
                    upper.offer(lower.poll());
                } else if (upper.size() > lower.size()) {
                    lower.offer(upper.poll());
                }

                if (lower.size() == upper.size()) {
                    medians.add((lower.peek() + upper.peek()) / 2.0);
                } else {
                    medians.add((double) lower.peek());
                }
            }
            return medians;
        }
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int aCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Double> result = Result.runningMedian(a);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
