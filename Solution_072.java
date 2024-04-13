//Waiter
//(O(n*m) + O(n*q))

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
You are a waiter at a party. There is a pile of numbered plates. Create an empty answers array. At each iteration, i. remove each plate from the top of the stack in order. Determine if the number on the plate is evenly divisible by the ith prime number. If it is, stack it in pile B. Otherwise, stack it in stack A. Store the values in B, from top to bottom in answers. In the next iteration, do the same with the values in stack A. Once the required number of iterations is complete, store the remaining values in A; in answers, again from top to bottom. Return the answers array. Example A = [2,3,4,5,6,7] 9=3 An abbreviated list of primes is [2, 3, 5, 7, 11, 13]. Stack the plates in reverse order. A₁ = [2,3,4,5,6,7] answers = Begin iterations. On the first iteration, check if items are divisible by 2. A₁ = [7,5,3] B₁ = [6,4,2] Move B₁ elements to answers. answers = [2,4,6] On the second iteration, test if Aj elements are divisible by 3. A₂ = [7,5] B₁ = [3] Move B₂ elmements to answers. answers = [2,4,6,3] And on the third iteration, test if A₂ elements are divisible by 5. A₁ = [7] B₁ = [5] Move B₂ elmements to answers. answers [2,4,6,3,5] All iterations are complete, so move the remaining elements in A3. from top to bottom, to answers. answers = [2,4,6, 3, 5, 7]. Return this list. Function Description Complete the waiter function in the editor below. waiter has the following parameters : ⚫ int number[n] : the numbers on the plates ⚫int q : the number of iterations
Returns ⚫ int[n] : the numbers on the plates after processing Input Format The first line contains two space separated integers, n and q. The next line contains space separated integers representing the initial pile of plates, i.e.., A. Constraints 1≤ n ≤5 x 10 2≤number[i] <104 1≤q≤1200 Sample Input 51 34765 Sample Output 46376 Explanation Initially : A0 =[3, 4, 7, 6, 5]<-TOP After 1 iteration : A₁ =0<-TOP B₁ = [6.4]<-TOP A₁ = [5.7.3]<-TOP We should output numbers in B₁ first from top to bottom, and then output numbers in A, from top to bottom.
*/

class Result_072 {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */
    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> primes = generatePrimes(q);
        List<Integer> answers = new ArrayList<>();

        Stack<Integer> answer = new Stack<>();
        Stack<Integer> numbers = makeStack(number);
        Stack<Integer> supported = new Stack<>();
        Stack<Integer> temp = null;

        for (Integer p : primes) {
            while (!numbers.empty()) {
                if (numbers.peek() % p == 0) {
                    answer.push(numbers.pop());
                } else {
                    supported.push(numbers.pop());
                }
            }
            while (!answer.empty()) {
                answers.add(answer.pop());
            }
            temp = numbers;
            numbers = supported;
            supported = temp;
        }
        while (!numbers.empty()) {
            answers.add(numbers.pop());
        }
        return answers;
    }

    public static Stack<Integer> makeStack(List<Integer> number) {
        Stack<Integer> stack = new Stack<>();
        for (Integer n : number) {
            stack.push(n);
        }
        return stack;
    }


    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int count = 0;
        boolean isPrime = true;
        int index = 0;
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (count == n) {
                break;
            }
            index = i / 2;
            while (index > 1) {
                if (i % index == 0) {
                    isPrime = false;
                    break;
                }
                index--;
            }
            if (isPrime) {
                primes.add(i);
                count++;
            }
            isPrime = true;
        }

        return primes;
    }
}

public class Solution_072 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result_072.waiter(number, q);

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

