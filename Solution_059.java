//Reverse a linked list
//O(n) for reverse function

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
This challenge is part of a tutorial track by MyCodeSchool and is accompanied by a video lesson.
Given the pointer to the head node of a linked list,
change the next pointers of the nodes so that their order is reversed.
The head pointer given may be null meaning that the initial list is empty.
Example head references the list 1→2→3→ NULL Manipulate the next pointers of each node in place and return head.
now referencing the head of the list 3 →2→1→ NULL
Function Description
 Complete the reverse function in the editor below. reverse has the following parameter :
 • SinglyLinkedListNode pointer head : a reference to the head of a list Returns
 ⚫ SinglyLinkedListNode pointer : a reference to the head of the reversed list
 Input Format The first line contains an integer t, the number of test cases.
 Each test case has the following format : The first line contains an integer n,
 the number of elements in the linked list. Each of the next lines contains an integer,
 the data values of the elements in the linked list. Constraints • 1st≤ 10 ⚫ 1≤ n ≤ 1000 1 listi] 1000.
 where list[] is the ith element in the list. Sample Input 1512345 Sample Output 54321 Explanation
 The initial linked list is : 1 2 3 4 5 → NULL. The reversed linked list is : 5→4→3→2→1→ NULL
*/


class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result_059 {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

}

public class Solution_059 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                SinglyLinkedListNode llist1 = Result_059.reverse(llist.head);

                SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
