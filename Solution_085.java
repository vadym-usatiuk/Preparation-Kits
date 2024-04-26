//Largest Rectangle
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
Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. Your task is to find the largest solid area in which the mall can be constructed. There are a number of buildings in a certain two-dimensional landscape. Each building has a height, given by h[i] where i Є [1, n]. If you join k adjacent buildings, they will form a solid rectangle of area kx min(hi, hi+1],...,hi+ k − 1]). Example h = [3,2,3] A rectangle of height h = 2 and length k = 3 can be constructed within the boundaries. The area formed is h. k = 2.3 = 6. Function Description Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings. largestRectangle has the following parameter(s) : ⚫ int h[n] : the building heights Returns - long : the area of the largest rectangle that can be formed within the bounds of consecutive buildings Input Format The first line contains n. the number of buildings. The second line contains 12 space-separated integers, each the height of a building. Constraints ⚫ 1≤ n ≤10³ ⚫ 1≤ h[i] ≤ 10% Sample Input STDIN 5 Function h[] size n = 5 12345 h = [1, 2, 3, 4, 5] Sample Output 9
*/

class Result_085 {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int n = h.size();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && h.get(stack.peek()) >= h.get(i)) {
                int height = h.get(stack.pop());
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = h.get(stack.pop());
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, (long) height * width);
        }
        return maxArea;
    }
}

public class Solution_085 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result_085.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
