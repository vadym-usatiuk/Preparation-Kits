//Mars Exploration
//Time complexity is O(n)

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


/*A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
Letters in some of the sos messages are altered by cosmic radiation during transmission.
Given the signal received by Earth as a string, s. determine how many letters of the sos message
have been changed by radiation. Example 8 = 'SOSTOT The original message was sossos.
Two of the message's characters were changed in transit.
Function Description Complete the marsExploration function in the editor below.
marsExploration has the following parameter(s) : • string s : the string as received on Earth Returns • int :
the number of letters changed during transmission
Input Format There is one line of input a single string.
8. Constraints . 15 length of s≤ 99 • length of s modulo 3 = 0 • $ will contain only uppercase English letters,
ascii[A-Z]. Explanation Sample 0 S = SOSSPSSQSSOR, and signal length [S] = 12. Sami sent 4 SOS messages (.e.: 12/3= 4).
Expected signal : SOSSossossos Recieved signal : SOSS SSQSSOR We print the number of changed letters,
which is 3. Sample 1 S = SOSSOT, and signal length [S] = 6. Sami sent 2 sos messages (.e.: 6/3 = 2).
Expected Signal : SOSsos Received Signal : SOSSOT We print the number of changed letters, which is 1.
*/
class Result_016 {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i += 3) {
            if (s.charAt(i) != 'S') count++;
            if (s.charAt(i + 1) != 'O') count++;
            if (s.charAt(i + 2) != 'S') count++;
        }
        return count;
    }

    // Test method
    public static void testMarsExploration() {
        // Test cases
        String[] signals = {"SOSSPSSQSSOR", "SOSSOT"};
        int[] expectedResults = {3, 1};

        // Run tests
        for (int i = 0; i < signals.length; i++) {
            int result = marsExploration(signals[i]);
            System.out.println("Signal: " + signals[i] +
                    ", Changed letters: " + result +
                    ", Expected: " + expectedResults[i]);
        }
    }
}

public class Solution_016 {
    public static void main(String[] args) throws IOException {
        //Local test
        Result_016.testMarsExploration();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        int result = Result_016.marsExploration(s);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}