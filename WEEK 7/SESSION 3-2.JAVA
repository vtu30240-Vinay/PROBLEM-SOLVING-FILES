import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {

            // Grades below 38 are not rounded
            if (grade < 38) {
                result.add(grade);
            } else {
                int nextMultiple = ((grade / 5) + 1) * 5;

                // Round if difference is less than 3
                if (nextMultiple - grade < 3) {
                    result.add(nextMultiple);
                } else {
                    result.add(grade);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(Integer.parseInt(bufferedReader.readLine().trim()));
        }

        List<Integer> result = gradingStudents(grades);

        for (int grade : result) {
            System.out.println(grade);
        }

        bufferedReader.close();
    }
}

INPUT;
4
73
67
38
33
OUTPUT;
75
67
40
33
