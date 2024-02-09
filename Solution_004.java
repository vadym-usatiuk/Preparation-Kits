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

class Result_004 {

//    Maria plays college basketball and wants to go pro.
//    Each season she maintains a record of her play.
//    She tabulates the number of times she breaks her season record for most points and
//    least points in a game. Points scored in the first game establish her record for the season,
//    and she begins counting from there. Example scores = [12, 24, 10, 24]
//    Scores are in the same order as the games played.
//    She tabulates her results as follows : Game NTO . 1 . 2 3
//    Score 12 24 10 24 Minimum 12 1 ≤ n ≤ 1000 12 10 10
//    Given the scores for a season, determine the number of times Maria breaks her records for most and
//    least points scored during the season. Maximum 12 24 24 24
//    Function Description Complete the breakingRecords function in the editor below.
//    breakingRecords has the following parameter(s) : • int scores[n] :
//    points scored per game Count Min Maxi 0 0 0 1 Returns • int[2] :
//    An array with the numbers of times she broke her records.
//    Index 0 is for breaking most points records,
//    and index 1 is for breaking least points records.
//    Input Format The first line contains an integer n. the number of games.
//    The second line contains n space-separated integers describing the respective values of scoreo, score,..
//    Constraints 0 scores[i] 108 1 1 1 1 scoren-1

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int highestScore = scores.get(0);
        int lowestScore = scores.get(0);
        int maxRecordBreaks = 0;
        int minRecordBreaks = 0;

        for (int i = 1; i < scores.size(); i++) {
            int currentScore = scores.get(i);
            if (currentScore > highestScore) {
                highestScore = currentScore;
                maxRecordBreaks++;
            }
            if (currentScore < lowestScore) {
                lowestScore = currentScore;
                minRecordBreaks++;
            }
        }

        List<Integer> recordBreaks = new ArrayList<>();
        recordBreaks.add(maxRecordBreaks);
        recordBreaks.add(minRecordBreaks);
        return recordBreaks;
    }

}

public class Solution_004 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result_004.breakingRecords(scores);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining(" "))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
        List<Integer> scores = Arrays.asList(12, 24, 10, 24);
        List<Integer> result = Result_004.breakingRecords(scores);
        System.out.println("Number of times Maria breaks her records: " + result.get(0) + " (max), " + result.get(1) + " (min)");
    }
}

