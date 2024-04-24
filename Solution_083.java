//Permutation game
//O(n!)

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
Alice and Bob play the following game : 1. They choose a permutation of the numbers 1 to n. 2. Alice plays first and they alternate. 3. In a turn, they can remove any one remaining number from the permutation. 4. The game ends when the remaining numbers form an increasing sequence of 1 or more numbers. The person who played the turn that leaves an increasing sequence wins the game. Assuming both play optimally, who wins the game? Return Alice or Bob. Example arr =[4,2,3,1] This is the starting permutation to analyze, n = 4. First, Alice chooses 3 or 2. For the example, Alice chooses 3 and leaves arr =[4,2,1]. Since this is a decreasing sequence, Bob can remove any number for optimum play. He will lose regardless. Alice then removes any number leaving an array of only one element. Since Alice removed the last element to create an increasing sequence, Alice wins. Function Description Complete the permutationGame function in the editor below. permutationGame has the following parameter : - int arr[n] : the starting permutation Returns ⚫ string : either Alice or Bob Input Format The first line contains the number of test cases t. Each of the next t pairs of lines is in the following format : -The first line contains an integer n. the size of the array arr -The second line contains n space-separated integers, arr[i] where 0<i<n Constraints ⚫ 1≤t≤ 100 • 2≤ n ≤15 The permutation will not be an increasing sequence initially.
Sample Input STDIN Function 2 t = 2 3 132 5 arr[] size n = 3 arr = [1, 3, 2] n = 5 53214 arr = [5, 3, 2, 1, 4] Sample Output Alice Bob Explanation For the first test, Alice can remove 3 or 2 to leave an increasing sequence and win the game. For the second test, if 4 is removed then the only way to have an increasing sequence is to only have 1 number left. This takes a total of 4 moves. and Bob wins. If Alice removes the 4 on the first move, it will take 3 more moves to create an increasing sequence. Bob wins. If Alice removes something else, Bob can remove 4 on his next turn to create the same game state. It is a decreasing sequence with 3 numbers left.
*/
class Result_083 {

    /*
     * Complete the 'permutationGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    static Map<String, Boolean> memo = new HashMap<>();

    public static String permutationGame(List<Integer> arr) {
// Write your code here
        memo.clear();
        return findWinner(arr) ? "Bob" : "Alice";

    }

    static boolean isIncreasing(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean findWinner(List<Integer> arr) {
        String key = arr.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (isIncreasing(arr)) {
            memo.put(key, true);
            return true;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (findWinner(Stream.concat(arr.subList(0, i).stream(),
                            arr.subList(i + 1, arr.size()).stream())
                    .collect(Collectors.toList()))) {
                memo.put(key, false);
                return false;
            }
        }
        memo.put(key, true);
        return true;
    }
}

public class Solution_083 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result_083.permutationGame(arr);

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

