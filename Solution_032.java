//Tower Breakers
//O(1)

import java.io.IOException;

/*
Two players are playing a game of Tower Breakers! Player 1 always moves first,
 and both players always play optimally.The rules of the game are as follows :
  • Initially there are n towers. . Each tower is of height m. The players move in alternating turns.
  • In each turn, a player can choose a tower of height and reduce its height to y, where 1Sy and y evenly divides.
  . If the current player is unable to make a move, they lose the game. Given the values of n and m,
  determine which player will win. If the first player wins, return 1. Otherwise, return 2 Example. n = 2 772 = 6
  There are 2 towers, each 6 units tall Player 1 has a choice of two moves :
  -remove 3 pieces from a tower to leave 3 as 6 modulo 3 = 0 -remove 5 pieces to leave 1 Let Player 1 remove 3.
  Now the towers are 3 and 6 units tall. Player 2 matches the move. Now the towers are both 3 units tall.
  Now Player 1 has only one move. Player 1 removes 2 pieces leaving 1. Towers are 1 and 2 units tall.
  Player 2 matches again. Towers are both 1 unit tall. Player 1 has no move and loses. Return 2.
  Function Description Complete the towerBreakers function in the editor below towerBreakers has the following
  parame int n : the number of towers. int mc the height of each tower Returns int : the winner of the game
  Input Format The first line contains a single integer , the number of test cases. E
  ach of the next lines describes a test case in the form of 2 space separated integers, and m.
  Constraints 1sts 100 1≤n, m≤ 10 Sample Input STDIN Function 2 22 14 t-2 n-2, m-2 n-1-4
  Sample Output Explanation We'll refer to player 1 as P1 and player 2 as P2 In the first test case,
  Pl chooses one of the two towers and reduces it to 1. Then P2 reduces the remaining tower to a height of 1.
  As both towers now have height 1, P1 cannot make a move so P2 is the winner. in the second test case,
  there is only one tower of height 4. P1 can reduce it to a height of either 1 or 2.
  Pl chooses 1 as both players always choose optimally. Because P2 has no possible move, P1 wins.
*/
class Result_032 {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        if (n % 2 == 0 || m == 1) {
            return 2;
        } else {
            return 1;
        }
    }
}

public class Solution_032 {
    public static void main(String[] args) throws IOException {

        // Test case 1: n is even
        int result1 = Result_032.towerBreakers(4, 3);
        System.out.println("Test Case 1: " + (result1 == 2 ? "Pass" : "Fail")); // Expected output: Pass

        // Test case 2: n is odd and m is 1
        int result2 = Result_032.towerBreakers(3, 1);
        System.out.println("Test Case 2: " + (result2 == 2 ? "Pass" : "Fail")); // Expected output: Pass

        // Test case 3: n is odd and m is not 1
        int result3 = Result_032.towerBreakers(5, 4);
        System.out.println("Test Case 3: " + (result3 == 1 ? "Pass" : "Fail")); // Expected output: Pass


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int n = Integer.parseInt(firstMultipleInput[0]);
//
//                int m = Integer.parseInt(firstMultipleInput[1]);
//
//                int result = Result_032.towerBreakers(n, m);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

