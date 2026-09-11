import java.io.*;
import java.util.*;

public class Solution {

    public static String twoStrings(String s1, String s2) {
        boolean[] present = new boolean[26];

        // Store characters of the first string
        for (int i = 0; i < s1.length(); i++) {
            present[s1.charAt(i) - 'a'] = true;
        }

        // Check characters of the second string
        for (int i = 0; i < s2.length(); i++) {
            if (present[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(twoStrings(s1, s2));
        }

        sc.close();
    }
}

INPUT;
2
hello
world
hi
world

OUTPUT;
YES
NO
