//Mock Test 5 - fibonacciModified
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
Implement a modified Fibonacci sequence using the following definition :
Given terms t) and ti+1] where i E (1, 0), term t[i+2] is computed as :
ti+2=t+(+1) Given three integers, t1, t2, and 1, compute and print the nth term of a modified Fibonacci sequence.
Example t1-0 t2=1 n1=6 . 13=0+12=1 . 14=1+12=2 .15 1+2 5 t6 2+52 27 Return 27.
Function Description Complete the fibonacciModified function in the editor below.
It must return the 7th number in the sequence. fibonacciModified has the following parameter(s) :
int t1 : an integer int t2 : an integer int n : the iteration to report Returns int :
the number in the sequence Note : The value of t[n] may far exceed the range of a 64-bit integer.
Many submission languages have libraries that can handle such large results but, for those that don't (e.g., C++),
you will need to compensate for the size of the result. Input Format A single line of three space-separated integers,
the values of t1, t2, and 1. Constraints 0t1, t2 ≤2 3≤ n ≤20 ⚫t may far exceed the range of a 64-bit integer.
Sample Input 015 Sample Output 5 Explanation The first two terms of the sequence are t10 and t2 = 1,
which gives us a modified Fibonacci sequence of {0, 1, 1, 2, 5, 27,...}. The 5th term is 5.
*/

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


class Result_044 {

    /*
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger[] fib = new BigInteger[n];
        fib[0] = BigInteger.valueOf(t1);
        fib[1] = BigInteger.valueOf(t2);

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 2].add(fib[i - 1].multiply(fib[i - 1]));
        }

        return fib[n - 1];
    }

}

public class Solution_044 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        BigInteger result = Result_044.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


