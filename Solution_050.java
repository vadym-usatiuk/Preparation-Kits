//Recursive Digit Sum
//O(m+log(sk))

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
We define super digit of an integer using the following rules : Given an integer,
we need to find the super digit of the integer. • If a has only 1 digit, then its super digit is.
⚫ Otherwise, the super digit of a is equal to the super digit of the sum of the digits of . .
For example, the super digit of 9875 will be calculated as :
super_digit(9875) super_digit(29) super digit(11) super_digit(2) 9+8+7+5 = 29 2 + 9 = 11 1+1=2 = 2
Example n ='9875' k = 4 The number p is created by concatenating the string n k times
so the initial p=9875987598759875. superDigit(p) = superDigit(9875987598759875)
9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116 superDigit(p) = superDigit(116) 1+1+6 = 8
superDigit(p) = superDigit(8) All of the digits of p sum to 116.
The digits of 116 sum to 8.8 is only one digit, so it is the super digit.
Function Description Complete the function superDigit in the editor below.
It must return the calculated super digit as an integer. superDigit has the following parameter(s) :
⚫ string n : a string representation of an integer
⚫int k : the times to concatenate n to make p Returns
⚫ int : the super digit of repeated k times
Input Format The first line contains two space separated integers, π and k.
Constraints ⚫1≤n<10100000 • 1≤ k ≤105
*/
class Result_050 {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        long sum = 0;
        for (char digit : n.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }

        sum *= k;
        return superDigitHelper(sum);
    }

    private static int superDigitHelper(long n) {
        if (n < 10) return (int) n;

        long nextSum = 0;
        while (n > 0) {
            nextSum += n % 10;
            n /= 10;
        }

        return superDigitHelper(nextSum);
    }

}

public class Solution_050 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result_050.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
