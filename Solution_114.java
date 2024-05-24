//Gena Playing Hanoi
//O(2 to the power of 2n)

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
The Tower of Hanoi is a famous game consisting of 3 rods and a number of discs of incrementally different diameters. The puzzle starts with the discs neatly stacked on one rod, ordered by ascending size with the smallest disc at the top. The game's objective is to move the entire stack to another rod, obeying the following rules : 1. Only one disk can be moved at a time. 2. In one move, remove the topmost disk from one rod and move it to another rod. 3. No disk may be placed on top of a smaller disk. Gena has a modified version of the Tower of Hanoi. This game of Hanoi has 4 rods and n disks ordered by ascending size. Gena has already made a few moves following the rules above. Given the state of Gena's Hanoi, determine the minimum number of moves needed to restore the tower to its original state with all disks on rod 1. Note : Gena's rods are numbered from 1 to 4. The radius of a disk is its index in the input array, so disk 1 is the smallest disk with a radius of 1. and disk n is the largest with a radius of n. Example posts = [4,3,2,1] In this case, the disks are arranged from large to small across the four rods. The largest disk, disk 4. is already on rod 1. so move disks 3,2 and 1 to rod 1, in that order. It takes 3 moves to reset the game. posts=[4,2,2,1] The largest disk, disk 4 with radius 4. is already on rod 1. Disk 3 is on rod 2 and must be below disk 2. Move disk 2 to rod 3. disk 3 to rod 1 and disk 2 to rod 1. Now move disk 1 to rod 1. It takes 3 moves to reset the game. Function Description Complete the hanoi function below. hanoi has the following parameters : ⚫int posts[n] : posts[i]) is the location of the disk with radius i Returns ⚫int : the minimum moves to reset the game to its initial state Input Format The first line contains a single integer, n. the number of disks. The second line contains n space-separated integers, where the ith integer is the index of the rod where the disk with diameter i is located.
Constraints 1≤ n ≤10 Sample Input STDIN Function 3 141 -------- size of posts [] n = 3 posts [1, 4, 1] Sample Output 3
*/

public class Solution_114 {

    class Result {

        /*
         * Complete the 'hanoi' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY posts as parameter.
         */

        static private long base;
        static private int numOfRods;
        static private int INF;

        static private int[] fillRods(List<Integer> posts) {
            int[] res = new int[numOfRods];

            int n = posts.size();
            for (int i = 0; i < n; i++) {
                int rod = posts.get(i) - 1;
                int diskVal = (int) Math.pow(2, i);

                res[rod] += diskVal;
            }

            return res;
        }

        public static long findState(int[] rods) {
            long res = 0;

            for (int i = 0; i < numOfRods; i++) {
                res += (long) rods[i] * (long) Math.pow(base, numOfRods - i - 1);
            }

            return res;
        }

        public static int[] fromStateToRods(long state) {
            int[] res = new int[numOfRods];

            for (int i = 0; i < numOfRods; i++) {
                res[i] = (int) ((state / Math.pow(base, numOfRods - i - 1)) % base);
            }

            return res;
        }

        public static int[] findTopDisks(int[] curRods) {
            int[] res = new int[numOfRods];

            for (int i = 0; i < numOfRods; i++) {
                if (curRods[i] == 0) {
                    res[i] = INF;
                } else {
                    res[i] = curRods[i] ^ (curRods[i] & (curRods[i] - 1));
                }
            }

            return res;
        }

        public static int hanoi(List<Integer> posts) {
            int n = posts.size();

            numOfRods = 4;
            base = (long) Math.pow(2, n);
            INF = (int) Math.pow(2, n);

            int[] rods = fillRods(posts);

            long startState = findState(rods);
            long winState = (base - 1) * (long) Math.pow(base, numOfRods - 1);

            LinkedList<ArrayList<Long>> queue = new LinkedList<>();
            TreeMap<Long, ArrayList<Integer>> checked = new TreeMap<>();

            queue.add(new ArrayList<>(Arrays.asList(startState, 1L, 0L)));
            checked.put(startState, new ArrayList<>(Arrays.asList(1, 0)));

            queue.add(new ArrayList<>(Arrays.asList(winState, 2L, 0L)));
            checked.put(winState, new ArrayList<>(Arrays.asList(2, 0)));

            long state;
            long stateType;
            long stateMoves;
            long toAdd;
            long toSubtract;
            long newState;
            int[] curRods = new int[numOfRods];
            int[] topDisks = new int[numOfRods];
            ArrayList<Long> queueObject;

            while (!queue.isEmpty()) {
                queueObject = queue.pollFirst();

                state = queueObject.get(0);
                stateType = queueObject.get(1);
                stateMoves = queueObject.get(2);

                curRods = fromStateToRods(state);
                topDisks = findTopDisks(curRods);

                for (int i = 0; i < 4; i++) {
                    for (int j = i + 1; j < 4; j++) {

                        if (topDisks[i] == INF && topDisks[j] == INF) {
                            continue;
                        }

                        if (topDisks[j] < topDisks[i]) {
                            toSubtract = (long) topDisks[j] * (long) Math.pow(base, numOfRods - j - 1);
                            toAdd = (long) topDisks[j] * (long) Math.pow(base, numOfRods - i - 1);
                        } else {
                            toSubtract = (long) topDisks[i] * (long) Math.pow(base, numOfRods - i - 1);
                            toAdd = (long) topDisks[i] * (long) Math.pow(base, numOfRods - j - 1);
                        }

                        newState = state - toSubtract + toAdd;
                        queueObject = new ArrayList<>(Arrays.asList(newState, stateType, stateMoves + 1));

                        if (checked.get(newState) == null) {
                            queue.add(queueObject);
                            checked.put(newState, new ArrayList<>(Arrays.asList((int) stateType, (int) stateMoves + 1)));
                        } else if (checked.get(newState).get(0) != stateType) {
                            return (int) stateMoves + 1 + checked.get(newState).get(1);
                        }
                    }
                }
            }

            return -1;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> loc = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int res = Result.hanoi(loc);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
