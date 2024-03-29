//Reverse a doubly linked list
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

/*
Given the pointer to the head node of a doubly linked list, reverse the order of the nodes in place.
That is, change the next and prev pointers of the nodes so that the direction of the list is reversed.
Return a reference to the head node of the reversed list. Note :
The head node might be NULL to indicate that the list is empty.
Function Description Complete the reverse function in the editor below. reverse has the following parameter(s) :
⚫ Doubly LinkedListNode head :
a reference to the head of a DoublyLinkedList Returns -Doubly LinkedListNode :
a reference to the head of the reversed list
Input Format The first line contains an integer t, the number of test cases. Each test case is of the following format :
The first line contains an integer n, the number of elements in the linked list.
•The next lines contain an integer each denoting an element of the linked list.
Constraints . 1sts 10 ⚫0≤ n ≤ 1000 0≤ Doubly LinkedListNode.data <1000
Output Format Return a reference to the head of your reversed list.
The provided code will print the reverse array as a one line of space-separated integers for each test case.

Sample Input 1 Sample Output 4321 Explanation The initial doubly linked list is : 1+2+3+4+NULL
The reversed doubly linked list is : 4 + 3+2+1→ NULL
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

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

class Result_060 {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode prev = null;

        while (current != null) {
            DoublyLinkedListNode nextNode = current.next;
            current.next = prev;
            current.prev = nextNode; // swap prev and next pointers
            prev = current;
            current = nextNode;
        }

        //prev points to the new head of the reversed list
        return prev;
    }

}

public class Solution_060 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                DoublyLinkedListNode llist1 = Result_060.reverse(llist.head);

                DoublyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


