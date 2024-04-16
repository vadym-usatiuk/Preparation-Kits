//Equal Stacks
//O(n1 + n2 + n3)

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
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times. Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height, then return the height. Example h1= [1, 2, 1, 1] h2 = [1,1,2] h3 = [1,1] => There are 4,3 and 2 cylinders in the three stacks, with their heights in the three arrays. Remove the top 2 cylinders from h1 (heights = [1,2]) and from h2 (heights = [1, 1]) so that the three stacks all are 2 units tall. Return 2 as the answer. Note : An empty stack is still a stack. Function Description Complete the equalStacks function in the editor below. equalStacks has the following parameters : int hl[nl] : the first array of heights ⚫int h2[n2] : the second array of heights ⚫int h3[n3] : the third array of heights Returns ⚫int : the height of the stacks when they are equalized Input Format The first line contains three space-separated integers, n1. 12. and n3. the numbers of cylinders in stacks 1. 2. and 3. The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom : ⚫The second line contains 11 space-separated integers, the cylinder heights in stack 1. The first element is the top cylinder of the stack. The third line contains 12 space-separated integers, the cylinder heights in stack 2. The first element is the top cylinder of the stack. • The fourth line contains 113 space-separated integers, the cylinder heights in stack 3. The first element is the top cylinder of the stack. Constraints 0<n1, n2, n3 105 ⚫0<height of any cylinder 100
Sample Input

STDIN       Function
-----       --------
5 3 4       h1[] size n1 = 5, h2[] size n2 = 3, h3[] size n3 = 4
3 2 1 1 1   h1 = [3, 2, 1, 1, 1]
4 3 2       h2 = [4, 3, 2]
1 1 4 1     h3 = [1, 1, 4, 1]
Sample Output
*/
class Result_075 {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            stack1.push(h1.get(i));
            sum1 += h1.get(i);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            stack2.push(h2.get(i));
            sum2 += h2.get(i);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            stack3.push(h3.get(i));
            sum3 += h3.get(i);
        }

        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
            int minSum = Math.min(sum1, Math.min(sum2, sum3));

            while (sum1 > minSum) sum1 -= stack1.pop();
            while (sum2 > minSum) sum2 -= stack2.pop();
            while (sum3 > minSum) sum3 -= stack3.pop();

            if (sum1 == sum2 && sum2 == sum3) return sum1;
        }

        return 0;
    }

}

public class Solution_075 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_075.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
