////Tree: Preorder Traversal
////O(n)
//
//import java.util.*;
//import java.io.*;
//
////Complete the preOrder function in the editor below, which has 1 parameter : a pointer to the root of a binary tree. It must print the values in the tree's preorder traversal as a single line of space-separated values. Input Format Our test code passes the root node of a binary tree to the preOrder function. Constraints 1 Nodes in the tree < 500 Output Format Print the tree's preorder traversal as a single line of space-separated values. Sample Input 1 2 5 / \ 3 6 \ 4 Sample Output 1 2 5 3 4 6 Explanation The preorder traversal of the binary tree is printed.
//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}
//
//class Solution_097 {
//
///* you only have to complete the function given below.
//Node is defined as
//
//class Node {
//    int data;
//    Node left;
//    Node right;
//}
//
//*/
//
//    public static void preOrder(Node root) {
//        if (root != null) {
//            System.out.print(root.data + " ");
//            preOrder(root.left);
//            preOrder(root.right);
//        }
//    }
//
//    public static Node insert(Node root, int data) {
//        if (root == null) {
//            return new Node(data);
//        } else {
//            Node cur;
//            if (data <= root.data) {
//                cur = insert(root.left, data);
//                root.left = cur;
//            } else {
//                cur = insert(root.right, data);
//                root.right = cur;
//            }
//            return root;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int t = scan.nextInt();
//        Node root = null;
//        while (t-- > 0) {
//            int data = scan.nextInt();
//            root = insert(root, data);
//        }
//        scan.close();
//        preOrder(root);
//    }
//}
