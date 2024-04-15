//Simple Text Editor
//O(1)

import java.io.*;
import java.util.*;

/*
Implement simple text editor. The actor intially conteren empty string 8. Perform operation of the following 4 typ 1.append(W)-Append string W to the end of $ 2. c)-Det the A print)-Print the character of f 4. undo)- Undo the last (not previously uncone) operation of type 1 or 2 neverting 8 to the set was in prior to that operation. Example os 1 fg, '34', '2 5', '4', '87', '4', '3 4 operation opende plation ° L 2 A 4 b 4 del print the letter- undo the last operation, index 2 delprint the 7th character-g undo the bat operation, inde 4 print the 4th character-d The results should be printed InputFormat The findine conter an integer Q, denoting the number of operations Each line of the quanti (where <Qfines an operation to be performed. Each operation sets with a single integer (where (1,2,3,4) denoting type of operation as defined in the Problem Statement above the operation use an argument is followed by its space- argument. For example, if 1d Wabed", ine wil be abo Constraints . 1991 14 The sum of the length of all W in the input 10% The sum of over al cele perstore 2.10 All input characters are lowercame English letters ⚫ guaranteed that the sequence of operations given input posible to perform OutputFormat Each operation of type 3 mat print the Acharacter on a new line Sample Input SILIN Function a 1 be op 33-3 23. 1xy 42 4 Sample Output Explanation Italy 8 empty. The following sequence of operation as described below 2. Print the 3. Delete the 4. Append 5. Print the character on a new line Cumently the g t 3 chews in 8 skelm 8=" to 88="ay" character on a new line. Cumenty, the character b. Undo the last update to 8 making 8 empty again. S 7. Undothened to st update to 8 (the deletion of the let 3 chance making S="abc" 8. Print the 1 character on a new line. Currently, the 1 chache is a
*/

public class Solution_074 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int Q = Integer.parseInt(bufferedReader.readLine().trim());
        StringBuilder S = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < Q; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            int type = Integer.parseInt(inputs[0]);

            switch (type) {
                case 1: // Append(W)
                    history.push(S.toString());
                    S.append(inputs[1]);
                    break;
                case 2: // Delete(k)
                    int k = Integer.parseInt(inputs[1]);
                    history.push(S.toString());
                    S.delete(S.length() - k, S.length());
                    break;
                case 3: // Print(k)
                    int index = Integer.parseInt(inputs[1]) - 1;
                    bufferedWriter.write(S.charAt(index));
                    bufferedWriter.newLine();
                    break;
                case 4: // Undo
                    S = new StringBuilder(history.pop());
                    break;
            }
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
