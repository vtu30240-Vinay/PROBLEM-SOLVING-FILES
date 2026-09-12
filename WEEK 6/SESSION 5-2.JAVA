import java.io.*;
import java.util.*;

public class Solution {

    static int[] manacher(String s) {
        int n = s.length();

        // Transform string:
        // "abba" -> "#a#b#b#a#"
        int m = 2 * n + 1;
        int[] p = new int[m];

        int center = 0;
        int right = 0;

        for (int i = 0; i < m; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, mirror >= 0 ? p[mirror] : 0);
            }
 
            while (i + p[i] + 1 < m &&
                   i - p[i] - 1 >= 0 &&
                   getChar(s, i + p[i] + 1) ==
                   getChar(s, i - p[i] - 1)) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        return p;
    }

    static char getChar(String s, int pos) {
        if ((pos & 1) == 0) {
            return '#';
        }
        return s.charAt(pos / 2);
    }

    static List<Integer> circularPalindromes(String s) {
        int n = s.length();

        if (n == 1) {
            return Collections.singletonList(1);
        }

        // Duplicate the string so circular palindromes
        // can be handled as normal substrings.
        String doubled = s + s;

        int[] p = manacher(doubled);

        int[] best = new int[n];

        /*
         * For every possible center, determine the range of
         * rotations for which this palindrome can occur.
         */
        for (int center = 0; center < p.length; center++) {

            int radius = p[center];

            if (radius == 0)
                continue;

            // Maximum palindrome length cannot exceed n.
            int maxLen;

            if ((center & 1) == 0) {
                // Odd length palindrome
                maxLen = Math.min(radius, n - 1);
            } else {
                // Even length palindrome
                maxLen = Math.min(radius, n);
            }

            /*
             * Convert transformed-string center into an
             * original-string position.
             */
            int pos = center / 2;

            /*
             * The palindrome can cover rotations around this
             * position. We update all affected rotations.
             */
            int left = pos - maxLen + 1;
            int right = pos;

            for (int k = left; k <= right; k++) {
                int rotation = ((k % n) + n) % n;

                int possible = maxLen;

                if ((center & 1) == 0) {
                    // Odd palindrome
                    possible = 2 * ((maxLen - 1) / 2) + 1;
                } else {
                    // Even palindrome
                    possible = 2 * (maxLen / 2);
                }

                best[rotation] = Math.max(best[rotation], possible);
            }
        }

        /*
         * Every rotation must have at least a palindrome
         * of length 1.
         */
        for (int i = 0; i < n; i++) {
            if (best[i] == 0) {
                best[i] = 1;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int x : best) {
            result.add(x);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        List<Integer> ans = circularPalindromes(s);

        StringBuilder out = new StringBuilder();

        for (int x : ans) {
            out.append(x).append('\n');
        }

        System.out.print(out);
    }
}
OUTPUT;
5
aaaaa


