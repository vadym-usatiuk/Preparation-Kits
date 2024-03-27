//Climbing the Leaderboard
//O(n + m)

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
An arcade game player wants to climb to the top of the leaderboard and track their ranking.
The game uses Dense Ranking, so its leaderboard works like this :
• The player with the highest score is ranked number 1 on the leaderboard.
• Players who have equal scores receive the same ranking number,
and the next player(s) receive the immediately following ranking number.
Example ranked = [100, 90, 90, 80] player = [70, 80, 105]
The ranked players will have ranks 1, 2, 2, and 3, respectively.
If the player's scores are 70, 80 and 105, their rankings after each game are 4th, 3rd and 1st.
Return [4, 3, 1]. Function Description Complete the climbing Leaderboard function in the editor below.
climbing Leaderboard has the following parameter(s) :
⚫ int ranked[n] : the leaderboard scores • int player[m] : the player's scores Returns • int[m] :
the player's rank after each new score Input Format The first line contains an integer n,
the number of players on the leaderboard. The next line contains n space-separated integers ranked[i],
the leaderboard scores in decreasing order. The next line contains an integer, m, the number games the player plays.
The last line contains m space-separated integers player [j], the game scores. Constraints • 1≤ n ≤2×105 • 1≤m≤2×105
⚫0≤ ranked[i] <109 for 0 <i<n
⚫ 0 ≤ player[j] ≤ 10° for 0 ≤ j <m • The existing leaderboard, ranked, is in descending order.
• The player's scores, player, are in ascending order.
Subtask For 60% of the maximum score : .1≤ n ≤200
⚫ 1≤m ≤ 200 Sample Input 1 Sample Output 1 6 4 2 1
Sample Input 2
Sample Output 2 65421
 7 100 100 50 40 40 20 10 4 5 25 50 120 6 100 90 90 80 75 60 5 50 65 77 90 102
*/
class Result_058 {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> out = new ArrayList<>();
        ranked = ranked.stream().distinct().collect(Collectors.toList());
        int size = player.size();
        int j = 0, i = 0;
        while (size > 0 && j < ranked.size()) {
            if (player.get(size - 1) >= ranked.get(j)) {
                out.add(i++, 1 + j);
                size--;
            } else {
                j++;
            }
        }
        while (size > 0) {
            out.add(i++, j + 1);
            size--;
        }
        Collections.reverse(out);
        return out;
    }

}

public class Solution_058 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result_058.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

