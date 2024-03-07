//Smart Number 2
//O(1)

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
In this challenge, the task is to debug the existing code to successfully execute all provided test files.
A number is called a smart number if it has an odd number of factors. Given some numbers,
find whether they are smart numbers or not. Debug the given function is smart_number to correctly check
if a given number is a smart number. Note : You can modify only one line in the given code and you cannot
add or remove any new lines. To restore the original code, click on the icon to the right of the language selector.
Input Format The first line of the input contains t, the number of test cases.
The next # lines contain one integer each. Constraints • 1≤t≤ 10³ • 1 ≤ n ≤ 10¹, where n, is the th integer.
Output Format The output should consist off lines.
In the line print YES if the th integer has an odd number of factors, else print NO.
Sample Input 4127 7 169 Sample Output YES NO NO YES Explanation The factors of 1 are just 1 itself.So the answer is YES.
 The factors of 2 are 1 and 2.It has even number of factors. The answer is NO.
 The factors of 7 are 1 and 7.lt has even number of factors. The answer is NO.
 The factors of 169 are 1,13 and 169.It has odd number of factors. The answer is YES.
*/
public class Solution_039 {
    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);
        if (num == val * val)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int test_cases;
        Scanner in = new Scanner(System.in);
        test_cases = in.nextInt();
        int num;
        for (int i = 0; i < test_cases; i++) {
            num = in.nextInt();
            boolean ans = isSmartNumber(num);
            if (ans) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}



