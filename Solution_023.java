//Maximum Perimeter Triangle
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
Given an array of stick lengths, use 3 of them to construct a non-degenerate triangle
with the maximum possible perimeter. Return an array of the lengths of its sides as 3 integers in non-decreasing order.
If there are several valid triangles having the maximum perimeter : 1. Choose the one with the longest maximum side.
2. If more than one has that maximum, choose from them the one with the longest minimum side.
3. If more than one has that maximum as well, print any one them. If no non-degenerate triangle exists,
return [-1]. Example sticks = [1, 2, 3, 4, 5, 10] The triplet (1, 2, 3) will not form a triangle.
Neither will (4, 5, 10) or (2, 3, 5), so the problem is reduced to (2, 3, 4) and (3, 4, 5).
The longer perimeter is 3+ 4+ 5 = 12.
Function Description Complete the maximumPerimeter Triangle function in the editor below.
maximumPerimeterTriangle has the following parameter(s) :
• int sticks[n] : the lengths of sticks available Returns • int[3] or int[1] :
the side lengths of the chosen triangle in non-decreasing order or -1
Input Format The first line contains single integer W, the size of array sticks.
The second line contains space-separated integers sticks[i], each a stick length.
Constraints • 3≤ n ≤ 50 . 1 sticks[i] ≤ 10° Explanation Sample Case 0 :
There are 2 possible unique triangles : 1. (1,1,1) 2. (1,3,3) The second triangle has the largest perimeter,
so we print its side lengths on a new line in non-decreasing order. Sample Case 1 : The triangle (1, 2, 3) is
degenerate and thus can't be constructed, so we print -1 on a new line.
*/
class Result_023 {

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        Collections.sort(sticks, Collections.reverseOrder());
        for (int i = 0; i <= sticks.size() - 3; i++) {
            int a = sticks.get(i);
            int b = sticks.get(i + 1);
            int c = sticks.get(i + 2);
            if (a < b + c) {
                return Arrays.asList(c, b, a);
            }
        }
        return Collections.singletonList(-1);
    }

}

public class Solution_023 {
    public static void main(String[] args) throws IOException {
        // Test cases
        List<List<Integer>> testCases = new ArrayList<>();
        testCases.add(Arrays.asList(1, 1, 1)); // Degenerate triangle
        testCases.add(Arrays.asList(1, 2, 3)); // Degenerate triangle
        testCases.add(Arrays.asList(1, 2, 2)); // Degenerate triangle
        testCases.add(Arrays.asList(1, 2, 4)); // No triangle possible
        testCases.add(Arrays.asList(1, 2, 5)); // No triangle possible
        testCases.add(Arrays.asList(1, 2, 3, 4, 5, 10)); // [3, 4, 5]
        testCases.add(Arrays.asList(1, 1, 2, 2, 3)); // [1, 2, 2]

        for (int i = 0; i < testCases.size(); i++) {
            List<Integer> result = Result_023.maximumPerimeterTriangle(testCases.get(i));
            System.out.println("Test Case " + (i + 1) + ": " + result);
        }

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result_023.maximumPerimeterTriangle(sticks);
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
