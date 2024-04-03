//Ice Cream Parlor
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
Two friends like to pool their money and go to the ice cream parlor.
They always choose two distinct flavors and they spend all of their money.
Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
Example. m 6 cost = [1,3,4,5,6] The two flavors that cost 1 and 5 meet the criteria. Using 1-based indexing,
they are at indices 1 and 4.
Function Description
 Complete the icecreamParlor function in the editor below. icecreamParlor has the following parameter(s) :
 int m : the amount of money they have to spend int costin] : the cost of each flavor of ice cream Returns int[2] :
 the indices of the prices of the two flavors they buy, sorted ascending
 Input Format
 The first line contains an integer, t, the number of trips to the ice cream parlor.
 The next sets of lines each describe a visit. a Each trip is described as follows :
 1. The integer m, the amount of money they have pooled.
 2. The integer n. the number of flavors offered at the time.
 3. n space-separated integers denoting the cost of each flavor : cost(cost [1], cost [2],..., cost [n]].
 Note : The index within the cost array represents the flavor of the ice cream purchased.
 Constraints • 1≤t≤50 • 2≤m≤ 104 • 2≤ n ≤104 1 cost[i] 10. vie [1,n] There will always be a unique solution.
Sample Input
STDIN Function 2 t=2 4 k=4 5 cost size n = 5 14532 cost [1.4.5.3.2] 4 k = 4 4 cost]
size n = 4 2243 cost=[2.2.4.3] Sample Output 14 12
Explanation
Sunny and Johnny make the following two trips to the parlor : 1.
The first time, they pool together m = 4 dollars.
Of the five flavors available that day, flavors 1 and 4 have a total cost of 1+3=4. 2.
The second time, they pool together m = 4 dollars. Of the four flavors available that day,
flavors 1 and 2 have a total cost of 2+2=4.

*/
class Result_065 {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        Map<Integer, Integer> flavorMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int currentFlavorCost = arr.get(i);
            int complementCost = m - currentFlavorCost;

            if (flavorMap.containsKey(complementCost)) {
                return Arrays.asList(flavorMap.get(complementCost) + 1, i + 1);
            }

            flavorMap.put(currentFlavorCost, i);
        }

        return null;
    }

}

public class Solution_065 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result_065.icecreamParlor(m, arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
