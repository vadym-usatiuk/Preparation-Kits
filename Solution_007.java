
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

class Result_007 {

/*
    There is a collection of input strings and a collection of query strings.
    For each query string, determine how many times occurs in the list of input strings.
    Return an array of the results. Example strings = ['ab',' ab', abc'] queries = ['ab', abc',' be']
    There are 2 instances of 'ab', 1 of 'abc and 0 of 'be'.
    For each query, add an element to the return array, results = [2, 1, 0].
    Function Description Complete the function matchingStrings in the editor below.
    The function must return an array of integers representing
    the frequency of occurrence of each query string in strings.
    matchingStrings has the following parameters :
    • string strings[n] - an array of strings to search • string queries[q] - an array of query strings Returns
    • int[q] : an array of results for each query
    Input Format The first line contains and integer n. the size of strings[].
    Each of the next n lines contains a string strings[i]. The next line contains q, the size of queries [].
    Each of the next g lines contains a string queries[i].
    Constraints 1 ≤ n ≤ 1000 1 ≤ q ≤ 1000 1≤ strings[i], [queries[i] ≤ 20.
*/

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        // Create a HashMap to store the frequency of each string in the strings list
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Create a list to store the results for each query
        List<Integer> results = new ArrayList<>();

        // For each query, look up its frequency in the frequencyMap
        for (String query : queries) {
            int frequency = frequencyMap.getOrDefault(query, 0);
            results.add(frequency);
        }

        return results;
    }
}

public class Solution_007 {
    public static void main(String[] args) throws IOException {
        runLocalTests(); // local only
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> res = Result_007.matchingStrings(strings, queries);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void runLocalTests() {
        List<String> strings1 = Arrays.asList("ab", "ab", "abc");
        List<String> queries1 = Arrays.asList("ab", "abc", "be");
        List<Integer> expected1 = Arrays.asList(2, 1, 0);
        List<Integer> result1 = Result_007.matchingStrings(strings1, queries1);
        System.out.println("Test Case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));
    }
}
