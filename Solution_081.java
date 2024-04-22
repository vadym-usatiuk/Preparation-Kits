//Lego Blocks
//O(m)

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
Using the blacks, you want to make a wall of hight and width of the wolle The wall should not have The wall you build should I brickar b? a straight vertical break a row of brick Good layouts Bad layouts Function Description Complete the pc fund 1515100 width of the wall valid permutations in al er of valid wall formator modulo (10+7) Sample Input STOEN Function Semple Output for the first c mber of bet co contains two space-pated in and 31°+7)-3 for the second cach » 31, ar ane black of width 2. However, the wall where all rows contain two blocks of width 1 is not a solid come as it can be divided vertically. Thus, the number of ways 2×2×2-17 and 7+7)-7.
*/

class Result_081 {

    public static long modBig(long i, long MOD) {
        long res = i % MOD;
        if (res < 0) {
            res += MOD;
        }
        return res;
    }

    //Right-to-left binary method from Wiki
    public static long modPow(long i, int pow, long MOD) {
        if (MOD == 1) {
            return 0;
        }

        long res = 1;
        i = i % MOD;

        while (pow > 0) {
            if (pow % 2 == 1) {
                res = (res * i) % MOD;
            }
            i = (i * i) % MOD;
            pow = (int) Math.floor(pow / 2.0);
        }

        return res;
    }

    public static int legoBlocks(int n, int m) {

        final long MOD = (long) Math.pow(10, 9) + 7;
        //this is a tetranacci sequence, OEIS A000078. http://oeis.org/A000078
        //in combination with a bit of Coin Change problem
        //we should find number of combinations to build a wall of 1 unit high first
        //there is only 1 way to build wall of w == 0|1 and h == 1
        //  block/width 0   1   2   3   4   5   6
        //  1           1   1   1   1   1   1   1   is there a mononacci sequence for constant??
        //  2           1   1   2   3   5   8   13  fibonacci : 2 blocks 1-2 block 3rd onward
        //  3           1   1   2   4   7   13  24  tribonacci : 3 blocks 1-3 block 4th onward
        //  4           1   1   2   4   8   15  29  tetranacci : 4 blocks 1-4 block 5th onward
        //So for this problem with 4 kinds of blocks, we should only forcus on
        //      the tetranacci and how to implement it

        ArrayList<Long> singleRow = new ArrayList<>();
        singleRow.add(1L);
        singleRow.add(1L);
        singleRow.add(2L);
        singleRow.add(4L);
        singleRow.add(8L);

        ArrayList<Long> allRows = new ArrayList<>();

        ArrayList<Long> solid = new ArrayList<>();
        solid.add(1L);
        solid.add(1L);

        for (int i = 0; i <= m; i++) {
            if (i > 4) {
                long sum = 0;
                for (int j = i - 1; j >= i - 4; j--) {
                    sum += singleRow.get(j);
                }
                sum = modBig(sum, MOD);
                singleRow.add(sum);
            }

            allRows.add(modPow(singleRow.get(i), n, MOD));

            if (i >= 2) {
                long allAtI = allRows.get(i);
                long solidAtI = allAtI;
                for (int j = i - 1; j >= 1; j--) {
                    long solidAtJ = solid.get(j);
                    long allAtIJ = allRows.get(i - j);
                    solidAtI = modBig(solidAtI - solidAtJ * allAtIJ, MOD);
                }
                solid.add(solidAtI);
            }
        }
        return (int) (solid.get(m) % MOD);
    }
}

public class Solution_081 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result_081.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

