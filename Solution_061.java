//Insert a node at a specific position in a linked list
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
Given the pointer to the head node of a linked list and an integer to insert at a certain position,
create a new node with the given integer as its data attribute,
insert this node at the desired position and return the head node.
A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
The head pointer given may be null meaning that the initial list is empty.
Example head refers to the first node in the list 1 →2→ 3 data = 4 position = 2
Insert a node at position 2 with data = 4. The new list is 1 →→2→4→3
Function Description Complete the function insertNodeAtPosition in the editor below.
It must return a reference to the head node of your finished list.
insertNodeAtPosition has the following parameters :
⚫ head : a SinglyLinkedListNode pointer to the head of the list
⚫ data : an integer value to insert as data in your new node
⚫position : an integer position to insert the new node, zero based indexing Returns
⚫ SinglyLinkedListNode pointer : a reference to the head of the revised list
Input Format The first line contains an integer n, the number of elements in the linked list.
Each of the next lines contains an integer SinglyLinkedListNode[i].data. The next line contains an integer data,
the data of the node that is to be inserted. The last line contains an integer position. Constraints .
1≤ n ≤1000
⚫1< SinglyLinkedListNode[i].data <1000, where SinglyLinkedListNode[i] is the ith element of the linked list.
⚫0≤ position ≤n. Sample Input 16 13 7 1 2 Sample Output 16 13 17 Explanation The initial linked list is 16 →13 →7.
Insert 1 at the position 2 which currently has 7 in it. The updated linked list is 16 → 13 → 1→ 7.
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

class Result_061 {

    /*
     * Complete the 'insertNodeAtPosition' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER data
     *  3. INTEGER position
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

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

        if (position == 0) {
            newNode.next = llist;
            return newNode;
        }

        SinglyLinkedListNode current = llist;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return llist;
    }

}

public class Solution_061 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int data = Integer.parseInt(bufferedReader.readLine().trim());

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode llist_head = Result_061.insertNodeAtPosition(llist.head, data, position);

        SinglyLinkedListPrintHelper.printList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

