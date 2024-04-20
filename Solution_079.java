//Chief Hopper
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
Chief's bot is playing an old DOS based game. There is a row of buildings of different heights arranged at each index along a number line. The bot starts at building 0 and at a height of 0. You must determine the minimum energy his bot needs at the start so that he can jump to the top of each building without his energy going below zero. Units of height relate directly to units of energy. The bot's energy level is calculated as follows : If the bot's bot Energy is less than the height of the building, his new Energy = bot Energy - (height - bot Energy) If the bot's bot Energy is greater than the height of the building, his new Energy = bot Energy+ (bot Energy - height) Example arr = [2,3,4,3,2] Starting with bot Energy = 4, we get the following table : botEnergy height delta 4 2 +2 6 3 +3 9 4 +5 14 3 25 2 +11 +23 48 That allows the bot to complete the course, but may not be the minimum starting value. The minimum starting bot Energy in this case is 3. Function Description Complete the chiefHopper function in the editor below. chiefHopper has the following parameter(s) : ⚫ int arr[n] : building heights Returns ⚫int : the minimum starting bot Energy Input Format The first line contains an integer n. the number of buildings. The next line contains n space-separated integers arr[1].. arr[n]. the heights of the buildings. Constraints ⚫ 1≤ n ≤105 • ⚫1≤ arr[i] <10³ where 1≤i≤n
Sample Input
5
3 4 3 2 4
sample Output
4
Sample Input
3
4 4 4
Sample Output
4
Explanation
Sample 1
If initial energy is 4, after step 1 energy is 5, after step 2 it's 6, after step 3 it's 9 and after step 4 it's 16, finally at step 5 it's 28.
You can verify for lower initial energy bot will have -ve energy in the end.
Sample 2
In the second test case if bot has energy 4, it's energy is changed by (4 - 4 = 0) at every step and remains 4.
*/
class Result_079 {

    /*
     * Complete the 'chiefHopper' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int chiefHopper(List<Integer> arr) {
        int energy = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            energy = (energy + arr.get(i) + 1) / 2;
        }
        return energy;
    }
}

public class Solution_079 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.chiefHopper(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

