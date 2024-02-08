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

class Result_003 {

//    Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
//    Note : - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
//    - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock. Example •
//    s'12 : 01 : 00PM' ● Return '12 : 01 : 00¹. s = '12 : 01 : 00AM' Return '00 : 01 : 00'.
//    Function Description Complete the timeConversion function in the editor below.
//    It should return a new string representing the input time in 24 hour format.
//    timeConversion has the following parameter(s) :
//    • string s : a time in 12 hour format Returns • string :
//    the time in 24 hour format Input Format A single strings that represents a time in 12-hour clock format
//    (i.e.: hh : mm : ssAM or hh : mm : ssPM). Constraints • All input times are valid Sample Input 07:05:45PM

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String[] parts = s.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2].substring(0, 2));
        String period = parts[2].substring(2);

        if (period.equals("PM") && hours < 12) {
            hours += 12;
        } else if (period.equals("AM") && hours == 12) {
            hours = 0;
        }
        String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return formattedTime;
    }
}

public class Solution_003 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = bufferedReader.readLine();
//
//        String result = Result_003.timeConversion(s);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
        runTests();
    }

    public static void runTests() {
        // Test cases
        String[] testCases = {
                "07:05:45PM", // Expected output: "19:05:45"
                "12:01:00PM", // Expected output: "12:01:00"
                "12:01:00AM", // Expected output: "00:01:00"
                "01:15:30AM", // Expected output: "01:15:30"
                "11:30:45AM"  // Expected output: "11:30:45"
        };

        for (String testCase : testCases) {
            String result = Result_003.timeConversion(testCase);
            System.out.println("Input: " + testCase + ", Output: " + result);
        }
    }
}

