// Migratory Birds
// O(n)

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
Given an array of bird sightings where every element represents a bird type id,
 determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount,
  return the smallest of their ids. Example arr = [1,1,2,2,3] There are two each of types 1 and 2,
   and one sighting of type 3. Pick the lower of the two types seen twice : type 1.
    Function Description Complete the migratoryBirds function in the editor below.
     migratoryBirds has the following parameter(s) : int arr[n] : the types of birds sighted .
      Returns int : the lowest type id of the most frequently sighted birds
      Input Format The first line contains an integer, 7, the size of arr.
      The second line describes arr as n space-separated integers, each a type number of the bird sighted.
      Constraints • 5≤n≤2 x 10⁰ . It is guaranteed that each type is 1. 2. 3. 4. or 5.
*/
class Result_022 {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdCounts = new HashMap<>();

        for (int birdType : arr) {
            birdCounts.put(birdType, birdCounts.getOrDefault(birdType, 0) + 1);
        }

        int maxCount = 0;
        int mostFrequentBird = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : birdCounts.entrySet()) {
            int currentCount = entry.getValue();
            if (currentCount > maxCount || (currentCount == maxCount && entry.getKey() < mostFrequentBird)) {
                mostFrequentBird = entry.getKey();
                maxCount = currentCount;
            }
        }

        return mostFrequentBird;
    }

}

public class Solution_022 {
    public static void main(String[] args) throws IOException {
        testMigratoryBirds();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result_022.migratoryBirds(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }


    public static void testMigratoryBirds() {
        List<Integer> arr = Arrays.asList(1, 1, 2, 2, 3);
        int expectedResult = 1; // Expected result based on the sample input

        int actualResult = Result_022.migratoryBirds(arr);

        if (actualResult == expectedResult) {
            System.out.println("Test passed: MigratoryBirds method returned the correct result.");
        } else {
            System.out.println("Test failed: MigratoryBirds method returned an incorrect result.");
        }
    }
}
