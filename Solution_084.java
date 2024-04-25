//QHEAP1
//O(Q log n)

import java.io.*;
import java.util.*;

/*
This question is designed to help you get a better understanding of basic heap operations. There are 3 types of query : ⚫"1" - Add an element to the heap. • "2" - Delete the element from the heap. ⚫ "3" - Print the minimum of all the elements in the heap. NOTE : It is guaranteed that the element to be deleted will be there in the heap. Also, at any instant, only distinct elements will be in the heap. Input Format The first line contains the number of queries, Q. Each of the next Q lines contains one of the 3 types of query. Constraints 1≤Q≤ 10³ -10°≤ 10⁹ Output Format For each query of type 3. print the minimum value on a single line. Sample Input STDIN Function insert 4 insert 9 5 Q = 5 14 19 323 3 24 3 Sample Output print minimum delete 4 print minimum Explanation After the first 2 queries, the heap contains (4,9). Printing the minimum gives 4 as the output. Then, the 4th query deletes 4 from the heap, and the 5th query gives 9 as the output.
*/

public class Solution_084 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < Q; i++) {
            int queryType = scanner.nextInt();

            switch (queryType) {
                case 1:
                    int elementToAdd = scanner.nextInt();
                    heap.add(elementToAdd);
                    break;
                case 2:
                    int elementToDelete = scanner.nextInt();
                    heap.remove(elementToDelete);
                    break;
                case 3:
                    System.out.println(heap.peek());
                    break;
            }
        }
        scanner.close();
    }
}