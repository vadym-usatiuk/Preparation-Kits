//Inserting a Node Into a Sorted Doubly Linked List
//O(1)

/*
Given a reference to the head of a doubly-linked list and an integer, data. create a new Doubly LinkedListNode object
having data value data and insert it at the proper location to maintain the sort.
Example head refers to the list 1 2 →4→ NULL data = 3 Return a reference to the new list : 1 2 3 4 NULL.
Function Description Complete the sorted insert function in the editor below. sorted Insert has two parameters :
⚫ Doubly LinkedListNode pointer head : a reference to the head of a doubly-linked list
⚫int data : An integer denoting the value of the data field for the Doubly LinkedListNode you must insert into the list.
Returns ⚫ DoublyLinkedListNode pointer : a reference to the head of the list Note :
Recall that an empty list (ie., where head = NULL) and a list with one element are sorted lists.
Input Format The first line contains an integer t, the number of test cases.
Each of the test case is in the following format : ⚫The first line contains an integer n,
the number of elements in the linked list. • Each of the next n lines contains an integer,
the data for each node of the linked list. • The last line contains an integer, data,
which needs to be inserted into the sorted doubly-linked list.
Constraints 1≤t≤10 ⚫ 1≤ n ≤1000 ⚫ 1≤ Doubly LinkedListNode.data <1000
Sample Input

STDIN   Function
-----   --------
1       t = 1
4       n = 4
1       node data values = 1, 3, 4, 10
3
4
10
5       data = 5
Sample Output

1 3 4 5 10

Explanation The initial doubly linked list is : 1 3 4 + 10 → NULL.
The doubly linked list after insertion is : 1345 10 → NULL
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution_066 {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
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

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    class Result_066 {

        /*
         * Complete the 'sortedInsert' function below.
         *
         * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
         * The function accepts following parameters:
         *  1. INTEGER_DOUBLY_LINKED_LIST llist
         *  2. INTEGER data
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

        public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

            if (llist == null) {
                return newNode;
            }

            if (data <= llist.data) {
                newNode.next = llist;
                llist.prev = newNode;
                return newNode;
            }

            DoublyLinkedListNode current = llist;

            while (current.next != null && current.next.data < data) {
                current = current.next;
            }

            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;

            return llist;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = Result_066.sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

