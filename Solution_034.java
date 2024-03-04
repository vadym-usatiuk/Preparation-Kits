//Caesar Cipher
//O(n)

import java.io.IOException;

/*Julius Caesar protected his confidential information by encrypting it using a cipher.
Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet,
just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
Original alphabet : abcdefghijklmnopqrstuvwxyz Alphabet rotated +3 : defghijklmnopqrstuvwxyzabc
Example s = There's-a-starman-waiting-in-the-sky k = 3 The alphabet is rotated by 3. matching the mapping above.
The encrypted string is Wkhuh’v-d-vwdupdq-zdlwlqj-1q-wkh-vnb. Note :
The cipher only encrypts letters : symbols, such as-, remain unencrypted.
Function Description Complete the caesarCipher function in the editor below.
caesar Cipher has the following parameter(s) : • string s : cleartext int k : the alphabet rotation factor
Returns • string : the encrypted string Input Format The first line contains the integer, n,
the length of the unencrypted string. The second line contains the unencrypted string, s. The third line contains k,
the number of letters to rotate the alphabet by. Constraints 1 ≤ n ≤ 100 0≤k ≤ 100 s is a valid
ASCII string without any spaces.
Sample Input

        11
        middle-Outz
        2
Sample Output

        okffng-Qwvb
        Explanation

        Original alphabet:      abcdefghijklmnopqrstuvwxyz
        Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

        m -> o
        i -> k
        d -> f
        d -> f
        l -> n
        e -> g
        -    -
        O -> Q
        u -> w
        t -> v
        z -> b*/
class Result_034 {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encrypted.append((char) ((ch - base + k) % 26 + base));
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }
}

public class Solution_034 {
    public static void main(String[] args) throws IOException {
        System.out.println(Result_034.caesarCipher("middle-Outz", 2)); // Expected output: "okffng-Qwvb"
        System.out.println(Result_034.caesarCipher("There's-a-starman-waiting-in-the-sky", 3)); // Expected output: "Wkhuh’v-d-vwdupdq-zdlwlqj-1q-wkh-vnb"
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String s = bufferedReader.readLine();
//
//        int k = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String result = Result_034.caesarCipher(s, k);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

