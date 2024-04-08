//Balanced Brackets
//O9n)

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
A bracket is considered to be any one of the following characters:(.).(.).[or]Two brackets are considered to be a matched pair if the an opening bracket(e..(or occurs to the left of a closing bracket(ie. 1.1or)of the exact same type.There are three types of matched pairs of brackets:0.0.and().A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.For example,is not balanced because the contents in between[and]are not balanced.The pair of square brackets encloses a single,unbalanced opening bracket,(,and the pair of parentheses encloses a single,unbalanced closing square bracket,]By this logic,we say a sequence of brackets is balanced if the following conditions are met: ⚫It contains no unmatched brackets.The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.Given strings of brackets,determine whether each sequence of brackets is balanced.If a string is balanced,return YES.Otherwise,return NO.Function Description Complete the function isBalanced in the editor below.isBalanced has the following parameter(s): ⚫strings:a string of brackets Returns string:either YES or NO Input Format The first line contains a single integer n.the number of strings.Each of the next lines contains a single string,a sequence of brackets.Constraints • 1≤ n ≤10³ ⚫15≤10.where is the length of the sequence. ⚫ All chracters in the sequences={{}.().[]}Output Format For each string,return YES or NO.Sample Input STDIN Function......3n=3[0]first s='0'(0seconds=[{}{{0}]}}third s="{{[[{0}]DY Sample Output YES NO YES Explanation 1. The string {0} meets both criteria for being a balanced string. 2. The string {0} is not balanced because the brackets enclosed by the matched pair [and] are not balanced : []). 3. The string meets both criteria for being a balanced string.
*/


class Result_070 {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}

public class Solution_070 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result_070.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (
                    IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
