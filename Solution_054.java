//The Bomberman Game
//O(rows * cols * n)


/*
Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.
Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds.
Once a bomb detonates, it's destroyed-along with anything in its four neighboring cells.
This means that if a bomb detonates in celli, j. any valid cells (±1,j) and (i,j±1) are cleared.
If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating,
so there's no chain reaction. Bomberman is immune to bombs, so he can move freely throughout the grid.
Here's what he does :
1. Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
2. After one second, Bomberman does nothing.
3. After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs.
No bombs detonate at this point. 4. After one more second, any bombs planted exactly three seconds ago will detonate.
Here, Bomberman stands back and observes. 5. Bomberman then repeats steps 3 and 4 indefinitely.
Note that during every second Bomberman plants bombs,
the bombs are planted simultaneously (ie, at the exact same moment),
and any bombs planted at the same time will detonate at the same time.
Given the initial configuration of the grid with the locations of Bomberman's first batch of planted bombs,
determine the state of the grid after N seconds. For example, if the initial grid looks like :
.0. it looks the same after the first second. After the second second, Bomberman has placed all his charges
000 000 000 At the third second, the bomb in the middle blows up, emptying all surrounding cells : 0.0 0.0
Function Description Complete the bomberMan function in the editory below. bomberMan has the following parameter(s) :
int n : the number of seconds to simulate ⚫string grid[r] : an array of strings that represents the grid Returns
string[r] : n array of strings that represent the grid in its final state Input Format The first line contains three
space-separated integers, c, and n. The number of rows, columns and seconds to simulate. Each of the next y lines
contains a row of the matrix as a single string of c characters. The character denotes an empty cell and
the 0 character (ascii 79) denotes a bomb. Constraints ⚫ 1≤r,c≤200 Subtask ⚫15200 for 40% of the maximum score.
Sample Input

STDIN           Function
-----           --------
6 7 3           r = 6, c = 7, n = 3
.......         grid =['.......', '...O...', '....O..',\
...O...                '.......', 'OO.....', 'OO.....']
....O..
.......
OO.....
OO.....
Sample Output

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
Explanation

The initial state of the grid is:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman spends the first second doing nothing, so this is the state after 1 second:

.......
...O...
....O..
.......
OO.....
OO.....
Bomberman plants bombs in all the empty cells during his second second, so this is the state after 2 seconds:

OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
OOOOOOO
In his third second, Bomberman sits back and watches all the bombs he planted 3 seconds ago detonate.
This is the final state after  seconds:

OOO.OOO
OO...OO
OOO...O
..OO.OO
...OOOO
...OOOO
*/
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

class Result_054 {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 0 || n == 1) {
            return grid;
        }
        // 3 -> 7 -> 11 -> 15 ...
        if (n == 3 || ((n - 4) % 4) == 3) {
            return bombsDetonateState3(grid);
        }
        // 5 -> 9 -> 13 ..
        if (((n - 4) % 4) == 1) {
            return bombsDetonateState5(grid);
        }
        if (n % 2 == 0) {
            return boardFullOfBombsState(grid);
        }
        return grid;
    }

    private static List<String> bombsDetonateState3(List<String> grid) {
        return explodeBombs(grid);
    }

    private static List<String> bombsDetonateState5(List<String> grid) {
        List<String> baseGrid = bombsDetonateState3(grid);
        return explodeBombs(baseGrid);
    }

    private static List<String> explodeBombs(List<String> grid) {
        List<String> newGrid = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.get(0).length(); j++) {
                char current = grid.get(i).charAt(j);
                char up = i - 1 >= 0 ? grid.get(i - 1).charAt(j) : '.';
                char down = i + 1 < grid.size() ? grid.get(i + 1).charAt(j) : '.';
                char left = j - 1 >= 0 ? grid.get(i).charAt(j - 1) : '.';
                char right = j + 1 < grid.get(0).length() ? grid.get(i).charAt(j + 1) : '.';
                if (current == 'O') {
                    sb.append('.');
                } else if (up == 'O' || down == 'O' || left == 'O' || right == 'O') {
                    sb.append('.');
                } else {
                    sb.append('O');
                }
            }
            newGrid.add(sb.toString());
        }
        return newGrid;
    }

    private static List<String> boardFullOfBombsState(List<String> grid) {
        return grid.stream().map(s -> "O".repeat(grid.get(0).length())).collect(toList());
    }
}

public class Solution_054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result_054.bomberMan(n, grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

