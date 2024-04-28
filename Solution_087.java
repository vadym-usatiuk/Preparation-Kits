//Hackerland Radio Transmitters
//O(n log n)

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
Hackerland is a one-dimensional city with houses aligned at integral locations along a road. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each transmitter has a fixed range meaning it can transmit a signal to all houses within that number of units distance away. Given a map of Hackerland and the transmission range, determine the minimum number of transmitters so that every house is within range of at least one transmitter. Each transmitter must be installed on top of an existing house. Example x = [1,2,3,5,9] k=1 3 antennae at houses 2 and 5 and 9 provide complete coverage. There is no house at location 7 to cover both 5 and 9. Ranges of coverage, are [1,2,3]. [5]. and [9]. Function Description Complete the hackerland RadioTransmitters function in the editor below. hackerlandRadioTransmitters has the following parameter(s) : int x[n] : the locations of houses int k : the effective range of a transmitter Returns ⚫ int : the minimum number of transmitters to install Input Format The first line contains two space-separated integers π and k. the number of houses in Hackerland and the range of each transmitter. The second line contains space-separated integers describing the respective locations of each house [i]. Constraints 1≤ n, k≤105 1≤ x[i] <10³ There may be more than one house at the same location. Subtasks ⚫ 1≤ n ≤1000 for 50% of the maximum score. Output Format Print a single integer denoting the minimum number of transmitters needed to cover all of the houses.
Sample Input 0

STDIN       Function
-----       --------
5 1         x[] size n = 5, k = 1
1 2 3 4 5   x = [1, 2, 3, 4, 5]
Sample Output 0

2
Explanation 0

The diagram below depicts our map of Hackerland:

k-nearest(2).png

We can cover the entire city by installing 2 transmitters on houses at locations 2 and 4.

Sample Input 1

8 2
7 2 4 6 5 9 12 11
Sample Output 1

3
Explanation 1

The diagram below depicts our map of Hackerland:

k-nearest2(2).png

We can cover the entire city by installing 3 transmitters on houses at locations 4, 9, 12.
*/
class Result_087 {

    /*
     * Complete the 'hackerlandRadioTransmitters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY x
     *  2. INTEGER k
     */

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);

        int transmitters = 0;
        int i = 0;

        while (i < x.size()) {
            int location = x.get(i);
            transmitters++;
            int nextCoverage = location + k;

            while (i < x.size() && x.get(i) <= nextCoverage) {
                i++;
            }

            int lastHouseInRange = x.get(i - 1);

            while (i < x.size() && x.get(i) <= lastHouseInRange + k) {
                i++;
            }
        }

        return transmitters;
    }

}

public class Solution_087 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_087.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

