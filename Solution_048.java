//Gaming Array 1
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
Andy wants to play a game with his little brother, Bob.
The game starts with an array of distinct integers and the rules are as follows :
Bob always plays first. In a single move, a player chooses the maximum element in the array.
He removes it and all elements to its right. For example, if the starting array arr = [2,3,5,4,1].
then it becomes arr[2,3] after removing [5, 4, 1]. The two players alternate turns.
The last player who can make a move wins. Andy and Bob play 9 games. Given the initial array for each game,
find and print the name of the winner on a new line. If Andy wins, print ANDY; if Bob wins, print BOB.
To continue the example above, in the next move Andy will remove 3.
Bob will then remove 2 and win because there are no more integers to remove.
Function Description Complete the gamingArray function in the editor below. gamingArray has the following parameter(s) :
int arr[n] : an array of integers Returns -string : either ANDY or BOB
Input Format The first line contains a single integer g. the number of games.
Each of the next 9 pairs of lines is as follows : .
The first line contains a single integer, the number of elements in arr.
The second line contains a distinct space-separated integers arr[i] where 0<i<n Constraints
Array arr contains 1 distinct integers.
For 35% of the maximum score : . 1≤9≤10 .1≤ n ≤1000 1≤ arr[i] ≤10
The sum of 12 over all games does not exceed 1000. For 100% of the maximum score :
. 1≤9≤100 .1≤ n ≤10  1≤ a ≤10 . The sum of 12 over all games does not exceed 10%.
*/
class Result_048 {

    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String gamingArray(List<Integer> arr) {
        int count = 0;
        int bigger = 0;

        for (Integer i : arr) {
            if (i > bigger) {
                bigger = i;
                count++;
            }
        }

        if (count % 2 == 0) {
            return "ANDY";
        }

        return "BOB";
    }
}

public class Solution_048 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result_048.gamingArray(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

