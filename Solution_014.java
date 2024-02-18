//Counting Valleys
//time complexity is: O(n)

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
An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly steps steps,
for every step it was noted if it was an uphill, U, or a downhill, D step. Hikes always start and end at sea level,
and each step up or down represents a 1 unit change in altitude. We define the following terms :
• A mountain is a sequence of consecutive steps above sea level,
starting with a step up from sea level and ending with a step down to sea level.
• A valley is a sequence of consecutive steps below sea level,
starting with a step down from sea level and ending with a step up to sea level.
Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
Example steps = 8 path = [DDUUUUDD] The hiker first enters a valley 2 units deep.
Then they climb out and up onto a mountain 2 units high. Finally, the hiker returns to sea level and ends the hike.
Function Description Complete the countingValleys function in the editor below.
counting Valleys has the following parameter(s) : • int steps : the number of steps on the hike
• string path : a string describing the path Returns • int :
the number of valleys traversed Input Format The first line contains an integer steps,
the number of steps in the hike. The second line contains a single string path,
of steps characters that describe the path. Constraints • 2 ≤ steps < 10 • path[i] = {UD}
Sample Input UDDDUDUU Sample Output Explanation If we represent as sea level, a step up as/, and a step down as \,
the hike can be drawn as : LA VV The hiker enters and leaves one valley.
*/

class Result_014 {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int level = 0; // Current altitude level
        int valleys = 0; // Number of traversed valleys
        for (char step : path.toCharArray()) {
            if (step == 'U') {
                level++; // Step up
                if (level == 0) {
                    valleys++; // Reached sea level after coming out of a valley
                }
            } else {
                level--; // Step down
            }
        }
        return valleys;
    }

    public static void testCountingValleys() {
        int steps = 8;
        String path = "UDDDUDUU";
        int result = Result_014.countingValleys(steps, path);
        System.out.println("Number of valleys traversed: " + result);
    }
}


public class Solution_014 {
    public static void main(String[] args) throws IOException {

        //local
        Result_014.testCountingValleys();

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result_014.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

