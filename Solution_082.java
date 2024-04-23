//Weighted Uniform Strings
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
A weighted string is a string of lowercase English letters where each letter has a weight. Character weights are 1 to 26 from a to z as shown below : b C e f g h 234567020 10 k 11 S 12 m 13 U 21 n 14 V ° 15 W р 16 x 8 १ 17 y 9 r 18 Z 2222222 19 20 23 24 25 26 ⚫ The weight of a string is the sum of the weights of its characters. For example : apple 1+16+16+12+5=50 hack 8+1+3+11=23 watch 23+1+20+3+8=53 CCCCC 3+3+3+3+3=15 1+1+1=3 aaa ZZZZ 26+26+26+26= 104 ⚫ A uniform string consists of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not. Given a string, s, let U be the set of weights for all possible uniform contiguous substrings of string s. There will ben queries to answer where each query consists of a single integer. Create a return array where for each query, the value is Yes if query[i] € U. Otherwise, append No. Note : The € symbol denotes that x[i] is an element of set U.
Example 8 = 'abbcccdddd' queries = [1,7,5,4,15]. Working from left to right, weights that exist are : string weight a 1 b 2 bb C CC ссс 4369 d 4 dd 8 ddd dddd 12 16 Now for each value in queries, see if it exists in the possible string weights. The return array is ['Yes', 'No', 'No', 'Yes', 'No']. Function Description Complete the weighted UniformStrings function in the editor below. weighted UniformStrings has the following parameter(s) : - string s : a string -int queries[n] : an array of integers Returns - string[n] : an array of strings that answer the queries Input Format The first line contains a strings, the original string. The second line contains an integer n, the number of queries. Each of the next 7 lines contains an integer queries[i].the weight of a uniform subtring of s that may or may not exist. Constraints 1 lengthofs, n ≤ 10° ⚫1< queries[i] <107 ⚫s will only contain lowercase English letters, ascii[a-z]. 8
*/

class Result_082 {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        List<String> result = new ArrayList<>();
        Set<Integer> weights = new HashSet<>();
        int count = 1;
        char prev = s.charAt(0);
        weights.add(prev - 'a' + 1);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                count = 1;
                prev = curr;
            }
            weights.add((curr - 'a' + 1) * count);
        }

        for (int query : queries) {
            result.add(weights.contains(query) ? "Yes" : "No");
        }

        return result;
    }
}

public class Solution_082 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
