//Goodland Electricity
//O(n^2)

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
Goodland is a country with a number of evenly spaced cities along a line.
The distance between adjacent cities is 1 unit. There is an energy infrastructure project planning meeting,
and the government needs to know the fewest number of power plants needed to provide electricity to the entire list of cities.
Determine that number. If it cannot be done, return -1. You are given a list of city data.
Cities that may contain a power plant have been labeled 1.
Others not suitable for building a plant are labeled 0.
Given a distribution range of k, find the lowest number of plants that must be built such that all cities are served.
The distribution range limits supply to cities where distance is less than k.
Example k = 3 arr = [0, 1, 1, 1, 0, 0, 0] Each city is 1 unit distance from its neighbors,
and we'll use 0 based indexing. We see there are 3 cities suitable for power plants, cities 1, 2 and 3.
If we build a power plant at arr[2], it can serve arr[0] through arr[4]
because those endpoints are at a distance of 2 and 2 <k. To serve arr[6],
we would need to be able to build a plant in city 4, 5 or 6. Since none of those is suitable,
we must return -1. It cannot be done using the current distribution constraint.
Function Description Complete the pylons function in the editor below. pylons has the following parameter(s) :
int k : the distribution range int arr[n] : each city's suitability as a building site Returns int :
the minimum number of plants required or -1 Input Format The first line contains two space-separated integers n and k,
the number of cities in Goodland and the plants' range constant.
The second line contains n space-separated binary integers where each integer indicates suitability for building a plant.
Constraints 1≤kn≤105 Each arr[i] = {0, 1}. Subtask 1≤kn≤1000 for 40% of the maximum score.
Output Format Print a single integer denoting the minimum number of plants that must be built so that all of Goodland's
cities have electricity. If this is not possible for the given value of k, print -1. Sample Input STDIN 62 0 1 1 1 1 0
Function arr[] size n = 6, k = 2 arr [0, 1, 1, 1, 1, 0] Sample Output 2 Explanation Cities c[1],c[2],c[3],
and c[4] are suitable for power plants. Each plant will have a range of k = 2. If we build in cities 2 cities,
c[1] and c[4], then all cities will have electricity.
*/

class Result_056 {

    /*
     * Complete the 'pylons' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pylons(int k, List<Integer> arr) {
        int plants = 0;
        int index = k - 1;
        int start = 0;
        while (index < arr.size()) {
            if (arr.get(index) == 1) {
                start = index + 1;
                plants++;
                if ((index + ((k - 1) * 2) + 1 > arr.size() - 1) && index + k < arr.size()) {
                    if (arr.subList(arr.size() - k, arr.size()).contains(1)) {
                        plants++;
                        break;
                    } else {
                        return -1;
                    }
                } else {
                    index += ((k - 1) * 2) + 1;
                }
            } else if (index == start) {
                return -1;
            } else {
                index--;
            }
        }
        return plants;
    }
}


public class Solution_056 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_056.pylons(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

