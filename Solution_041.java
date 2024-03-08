//The Full Counting Sort
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
Use the counting sort to order a list of strings associated with integers.
If two strings are associated with the same integer, they must be printed in their original order,
i.e. your sorting algorithm should be stable. There is one other twist : strings in the first half of the array are
to be replaced with the character - (dash, ascii 45 decimal). Insertion Sort and the simple version of Quicksort
are stable, but the faster in-place version of Quicksort is not since it scrambles around elements while sorting.
Design your counting sort to be stable. Example arr =[[0,'a'],[1,'b'],[0,'c'], [1,'d']]
The first two strings are replaced with. Since the maximum associated integer is 1,
set up a helper array with at least two empty arrays as elements.
The following shows the insertions into an array of three empty arrays. string converted list 1 a 2 b 3 с 4 d
The result is then printed : - c-d..
Function Description [0,0,0] [[-],0,0]] [[-], [-], []) [[-,c],[-],[]] [[-,c], [-,d], []]
Complete the countSort function in the editor below.
It should construct and print the sorted strings. countSort has the following parameter(s) :
string arr[n][2] : each arr[i] is comprised of two strings, x and s Returns
Print the finished array with each element separated by a single space.
Note : The first element of each arr[i], a. must be cast as an integer to perform the sort.
Input Format The first line contains 7, the number of integer/string pairs in the array arr.
Each of the next contains a[i] and s[i], the integers (as strings) with their associated strings.
Constraints 1≤ n ≤ 1000000 12 is even 18≤10 0<<100, xar s[3] consists of characters in the range ascii[a-z]
Output Format

Print the strings in their correct order, space-separated on one line.

Sample Input

20
0 ab
6 cd
0 ef
6 gh
4 ij
0 ab
6 cd
0 ef
6 gh
0 ij
4 that
3 be
0 to
1 be
5 question
1 or
2 not
4 is
2 to
4 the
Sample Output

- - - - - to be or not to be - that is the question - - - -
Explanation

The correct order is shown below. In the array at the bottom,
strings from the first half of the original array were replaced with dashes.

0 ab
0 ef
0 ab
0 ef
0 ij
0 to
1 be
1 or
2 not
2 to
3 be
4 ij
4 that
4 is
4 the
5 question
6 cd
6 gh
6 cd
6 gh
sorted = [['-', '-', '-', '-', '-', 'to'], ['be', 'or'], ['not', 'to'], ['be'], ['-', 'that', 'is', 'the'],
 ['question'], ['-', '-', '-', '-'], [], [], [], []]
*/
class Result_041 {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        // Write your code here
        var result = IntStream.range(0, arr.size())
                .mapToObj(i -> {
                    String v = arr.get(i).get(0);
                    if (i < arr.size() / 2) {
                        return new ArrayList<>(List.of(v, "-"));
                    } else {
                        return new ArrayList<>(List.of(v, arr.get(i).get(1)));
                    }
                })
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.get(0))))
                .map(ele -> ele.get(1))
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}

public class Solution_041 {
    public static void main(String[] args) throws IOException {
        List<List<String>> arr = new ArrayList<>();
        arr.add(Arrays.asList("0", "ab"));
        arr.add(Arrays.asList("6", "cd"));
        arr.add(Arrays.asList("0", "ef"));
        arr.add(Arrays.asList("6", "gh"));
        arr.add(Arrays.asList("4", "ij"));
        arr.add(Arrays.asList("0", "ab"));
        arr.add(Arrays.asList("6", "cd"));
        arr.add(Arrays.asList("0", "ef"));
        arr.add(Arrays.asList("6", "gh"));
        arr.add(Arrays.asList("0", "ij"));
        arr.add(Arrays.asList("4", "that"));
        arr.add(Arrays.asList("3", "be"));
        arr.add(Arrays.asList("0", "to"));
        arr.add(Arrays.asList("1", "be"));
        arr.add(Arrays.asList("5", "question"));
        arr.add(Arrays.asList("1", "or"));
        arr.add(Arrays.asList("2", "not"));
        arr.add(Arrays.asList("4", "is"));
        arr.add(Arrays.asList("2", "to"));
        arr.add(Arrays.asList("4", "the"));

        Result_041.countSort(arr);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<String>> arr = new ArrayList<>();
//
//        IntStream.range(0, n).forEach(i -> {
//            try {
//                arr.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        Result_042.countSort(arr);
//
//        bufferedReader.close();
    }
}

