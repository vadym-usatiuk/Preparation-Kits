//Number Line Jumps
//O(1)

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
You are choreographing a circus show with various animals.
For one act, you are given two kangaroos on a number line ready to jump in the positive direction
 (i.e, toward positive infinity). The first kangaroo starts at location 1 and moves at a rate of v1 meters per jump.
 The second kangaroo starts at location 2 and moves at a rate of v2 meters per jump.
 You have to figure out a way to get both kangaroos at the same location at the same time as part of the show.
 If it is possible, return YES, otherwise return NO. Example x1 = 2 v1 = 1 x2 = 1 v2 = 2 After one jump,
 they are both at x = 3, (1 + v1 = 2+1, x2 + v2 = 1 + 2), so the answer is YES.
 Function Description Complete the function kangaroo in the editor below. kangaroo has the following parameter(s) :
 • int x1, int v1 : starting position and jump distance for kangaroo 1 • int x2, int v2 :
 starting position and jump distance for kangaroo 2 Returns • string : either YES or NO
 Input Format A single line of four space-separated integers denoting the respective values of x1, v1, 2, and v2.
 Constraints . 0≤ al < 2 ≤ 10000 .1 v110000 102 10000
*/
class Result_029 {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x1 > x2 && v1 >= v2) || (x2 > x1 && v2 >= v1)) {
            return "NO";
        }
        int jumps = Math.abs(x1 - x2) / Math.abs(v1 - v2);
        if (x1 + jumps * v1 == x2 + jumps * v2) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class Solution_029 {
    public static void main(String[] args) throws IOException {
        testKangaroo();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int x1 = Integer.parseInt(firstMultipleInput[0]);
//
//        int v1 = Integer.parseInt(firstMultipleInput[1]);
//
//        int x2 = Integer.parseInt(firstMultipleInput[2]);
//
//        int v2 = Integer.parseInt(firstMultipleInput[3]);
//
//        String result = Result_029.kangaroo(x1, v1, x2, v2);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static void testKangaroo() {
        // Test case 1
        String result1 = Result_029.kangaroo(0, 3, 4, 2);
        System.out.println("Test case 1: " + result1); // Expected: YES

        // Test case 2
        String result2 = Result_029.kangaroo(0, 2, 5, 3);
        System.out.println("Test case 2: " + result2); // Expected: NO
    }
}

