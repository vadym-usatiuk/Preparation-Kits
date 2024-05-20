//Contacts
//O(nL)

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
We're going to make our own Contacts application! The application must perform two types of operations : 1. add name, where name is a string denoting a contact name. This must store name as a new contact in the application. 2. find partial, where partial is a string denoting a partial name to search the application for. It must count the number of contacts starting with partial and print the count on a new line. Given n sequential add and find operations, perform each operation in order. Example Operations are requested as follows : add ed add eddie add edward find ed add edwina find edw find a Three add operations include the names 'ed', 'eddie', and 'edward'. Next, find ed matches all 3 names. Note that it matches and counts the entire name 'ed'. Next, add 'edwina' and then find 'edw. 2 names match : 'edward' and 'edwina'. In the final operation, there are 0 names that start with 'a'. Return the array [3,2,0]. Function Description Complete the contacts function below. contacts has the following parameters : ⚫string queries[n] : the operations to perform Returns ⚫int : the results of each find operation Input Format The first line contains a single integer, n, the number of operations to perform (the size of queries[]). Each of the following lines contains a string. queries[i].
Constraints ⚫ 1≤ n ≤105 1length of name ≤21 1length of partial < 21 ⚫name and partial contain lowercase English letters only. The input does not have any duplicate name for the add operation. Sample Input STDIN add hack add hackerrank find hac find hak Function queries [] size n = 4 queries ['add hack', 'add hackerrank', 'find hac', 'find hak'] Sample Output 20 Explanation 1. Add a contact named hack. 2. Add a contact named hackerrank. 3. Find the number of contact names beginning with hac. Both name start with hac, add 2 to the return array. 4. Find the number of contact names beginning with hak. neither name starts with hak, add 0 to the return array.
*/
public class Solution_111 {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    class Result {

        /*
         * Complete the 'contacts' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts 2D_STRING_ARRAY queries as parameter.
         */

        public static List<Integer> contacts(List<List<String>> queries) {
            TrieNode root = new TrieNode();
            List<Integer> results = new ArrayList<>();

            for (List<String> query : queries) {
                String operation = query.get(0);
                String value = query.get(1);

                if (operation.equals("add")) {
                    addContact(root, value);
                } else if (operation.equals("find")) {
                    results.add(findPartial(root, value));
                }
            }

            return results;
        }

        private static void addContact(TrieNode root, String contact) {
            TrieNode current = root;
            for (char c : contact.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
                current.count++;
            }
        }

        private static int findPartial(TrieNode root, String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                current = current.children.get(c);
                if (current == null) {
                    return 0;
                }
            }
            return current.count;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<String>> queries = new ArrayList<>();

            IntStream.range(0, queriesRows).forEach(i -> {
                try {
                    queries.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            List<Integer> result = Result.contacts(queries);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
