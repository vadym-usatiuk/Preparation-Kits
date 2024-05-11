//Binary Search Tree : Lowest Common Ancestor
//O(n)

import java.util.*;
import java.io.*;

/*
You are given pointer to the root of the binary search tree and two values v1 and 2. You need to return the lowest common ancestor (LCA) of v1 and v2 in the binary search tree. 2 1 3 5 In the diagram above, the lowest common ancestor of the nodes 4 and 6 is the node 3. Node 3 is the lowest node which has nodes 4 and 6 as descendants. Function Description Complete the function Ica in the editor below. It should return a pointer to the lowest common ancestor node of the two values given. Ica has the following parameters : - root : a pointer to the root node of a binary search tree - v1 : a node.data value - v2 : a node.data value Input Format The first line contains an integer, n, the number of nodes in the tree. The second line contains n space-separated integers representing node. data values. The third line contains two space-separated integers. v1 and v2. To use the test data, you will have to create the binary search tree yourself. Here on the platform, the tree will be created for you.
Constraints 1≤ n, node.data ≤25 1≤ v1, v2 ≤25 v1 # v2 The tree will contain nodes with data equal to v1 and v2. Output Format Return the a pointer to the node that is the lowest common ancestor of v1 and v2. Sample Input 6 42 3176 17 2 1 3 7 v1 = 1 and v2 = 7. Sample Output [reference to node 4] Explanation LCA of 1 and 7 is 4, the root in this case. Return a pointer to the node.
*/

public class Solution_101 {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Solution {

        public static Node lca(Node root, int v1, int v2) {
            while (root != null) {
                if (root.data > v1 && root.data > v2) {
                    root = root.left;
                } else if (root.data < v1 && root.data < v2) {
                    root = root.right;
                } else {
                    return root;
                }
            }
            return null;
        }

        public static Node insert(Node root, int data) {
            if (root == null) {
                return new Node(data);
            } else {
                Node cur;
                if (data <= root.data) {
                    cur = insert(root.left, data);
                    root.left = cur;
                } else {
                    cur = insert(root.right, data);
                    root.right = cur;
                }
                return root;
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            Node root = null;
            while (t-- > 0) {
                int data = scan.nextInt();
                root = insert(root, data);
            }
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            scan.close();
            Node ans = lca(root, v1, v2);
            System.out.println(ans.data);
        }
    }
}
