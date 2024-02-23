//XOR Strings 3
// time complexity is O(n)

import java.io.*;
import java.util.*;


/*
In this challenge, the task is to debug the existing code to successfully execute all provided test files.
Given two strings consisting of digits 0 and 1 only, find the XOR of the two strings.
To know more about XOR Click Here Debug the given function strings xor to find the XOR of the two given
strings appropriately. Note : You can modify at most three lines in the given code and you cannot add
or remove lines to the code. To restore the original code, click on the icon to the right of the language selector.
Input Format The input consists of two lines. The first line of the input contains the first string, s,
and the second line contains the second string, t. Constraints • 1 ≤ s≤10¹
Output Format Print the string obtained by the XOR of the two input strings in a single line.
Sample Input 10101 00101 Sample Output 10000
Explanation The XOR of the two strings 10101 and 00101 is 100, 000, 101, 000, 101 = 10000
*/

public class Solution_020 {

    public static String stringsXOR(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i))
                res += "0";
            else
                res += "1";
        }

        return res;
    }

    public static void main(String[] args) {
        test();
//        String s, t;
//        Scanner in = new Scanner(System.in);
//        s = in.nextLine();
//        t = in.nextLine();
//        System.out.println(stringsXOR(s, t));

    }

    public static void test() {
        String s1 = "10101";
        String t1 = "00101";
        String expected1 = "10000";

        String result1 = stringsXOR(s1, t1);
        System.out.println("Result 1: " + result1);
        System.out.println("Expected 1: " + expected1);
        System.out.println("Test 1 Passed: " + result1.equals(expected1));
    }

}
