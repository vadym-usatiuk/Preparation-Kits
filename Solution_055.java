//New Year Chaos
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

class Result_055 {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int[] persons = {1, 2, 3};
        int brides = 0;
        for(int i = 0; i < q.size(); i++){
            if(q.get(i) == persons[0]){
                persons[0] = persons[1];
                persons[1] = persons[2];
                persons[2]++;
            }else if(q.get(i) == persons[1]){
                persons[1] = persons[2];
                persons[2]++;
                brides++;
            }else if(q.get(i) == persons[2]){
                persons[2]++;
                brides += 2;
            }else{
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(brides);
    }
}

public class Solution_055 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result_055.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

