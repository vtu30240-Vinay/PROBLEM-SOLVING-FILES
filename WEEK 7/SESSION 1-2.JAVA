import java.util.*;

class Student {
}

class Rockstar {
}

class Hacker {
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int studentCount = 0;
        int rockstarCount = 0;
        int hackerCount = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            if (type.equals("Student")) {
                studentCount++;
            } else if (type.equals("Rockstar")) {
                rockstarCount++;
            } else if (type.equals("Hacker")) {
                hackerCount++;
            }
        }

        System.out.println(studentCount + " "
                + rockstarCount + " "
                + hackerCount);

        sc.close();
    }
}
INPUT;
5
Student
Student
Rockstar
Hacker
Rockstar

OUTPUT;
2 2 1
