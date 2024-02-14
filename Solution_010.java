//Grading Students

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

class Result_010 {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

/*
    HackerLand University has the following grading policy :
    Every student receives a grade in the inclusive range from 0 to 100.
    • Any grade less than 40 is a failing grade.
    Sam is a professor at the university and likes to round each student's grade according to these rules :
    • If the difference between the grade and the next multiple of 5 is less than 3,
    round grade up to the next multiple of 5. • If the value of grade is less than 38,
    no rounding occurs as the result will still be a failing grade.
    Examples • grade = 84 round to 85 (85-84 is less than 3) • grade = 29 do not round
    (result is less than 40) • grade = 57 do not round (60-57 is 3 or higher)
    Given the initial value of grade for each of Sam's n students, write code to automate the rounding process.
    Function Description Complete the function gradingStudents in the editor below.
    gradingStudents has the following parameter(s) : int grades[n] :
    the grades before rounding Returns • int[n] :
    the grades after rounding as appropriate Input Format The first line contains a single integer, n,
    the number of students. Each line of the n subsequent lines contains a single integer, grades[i].
    Constraints • 1 ≤ n ≤ 60 . • 0≤ grades[i] ≤ 100
*/

    //time complexity is O(n)
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                roundedGrades.add(grade); // No rounding needed and add the original grade
            } else {
                int nextMultipleOf5 = (int) (Math.ceil(grade / 5.0) * 5); // Round up to the next multiple of 5
                if (nextMultipleOf5 - grade < 3) {
                    roundedGrades.add(nextMultipleOf5); // Round up
                } else {
                    roundedGrades.add(grade); // No rounding needed and add the original grade
                }
            }
        }
        return roundedGrades;
    }

    public static void testGradingStudents() {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        System.out.println("Original Grades: " + grades);
        List<Integer> roundedGrades = gradingStudents(grades);
        System.out.println("Rounded Grades: " + roundedGrades);
        // Expected output: [75, 67, 40, 33]
    }
}


public class Solution_010 {
    public static void main(String[] args) throws IOException {
        //local
        Result_010.testGradingStudents();

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<Integer> result = Result_010.gradingStudents(grades);
//
//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
