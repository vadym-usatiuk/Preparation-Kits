//No Prefix Set
//O(n*L)

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
There is a given list of strings where each string contains only lowercase letters from a-j. inclusive. The set of strings is said to be a GOOD SET if no string is a prefix of another string. In this case, print GOOD SET. Otherwise, print BAD SET on the first line followed by the string being checked. Note If two strings are identical, they are prefixes of each other. Example words = ['abcd', 'bed', 'abcde', 'bcde'] Here 'abcd' is a prefix of 'abcde' and 'bcd' is a prefix of 'bcde'. Since 'abcde' is tested first. print BAD SET abcde words=['ab', 'be', 'cd']. No string is a prefix of another so print GOOD SET Function Description Complete the noPrefix function in the editor below. noPrefix has the following parameter(s) : - string words[n] : an array of strings Prints -string(s) : either GOOD SET or BAD SET on one line followed by the word on the next line. No return value is expected. Input Format First line contains n, the size of words[]. Then next lines each contain a string, words[i]. Constraints 1≤ n ≤105 1 the length of words[i] <60 All letters in words[i] are in the range 'a' through ", inclusive.
Sample Input00 STDIN Function 7 aab defgab abcde aabcde cedaaa words[] size n = 7 words ['aab', 'defgab', 'abcde', 'aabcde', 'bbbbbbbbbb', 'jabjjjad'] bbbbbbbbbb jabjjjad Sample Output00 BAD SET aabcde Explanation 'aab' is prefix of 'aabcde' so it is a BAD SET and fails at string 'aabcde'. Sample Input01 aab aac aacghgh aabghgh Sample Output01 BAD SET aacghgh Explanation 'aab' is a prefix of 'aabghgh', and aac' is prefix of 'aacghgh'. The set is a BAD SET. 'aacghgh' is tested before 'aabghgh', so and it fails at 'aacghgh'
*/

class Solution_105 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    class Result {
        public static void noPrefix(List<String> words) {
            TrieNode root = new TrieNode();
            for (String word : words) {
                if (!insert(root, word)) {
                    System.out.println("BAD SET");
                    System.out.println(word);
                    return;
                }
            }
            System.out.println("GOOD SET");
        }

        private static boolean insert(TrieNode root, String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                if (current.isEndOfWord) {
                    return false;
                }
            }
            current.isEndOfWord = true;
            for (TrieNode child : current.children) {
                if (child != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> words = IntStream.range(0, n).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .collect(toList());

            Result.noPrefix(words);

            bufferedReader.close();
        }
    }
}
