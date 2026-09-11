class Solution {
    public boolean rotateString(String s, String goal) {

        // Rotated strings must have the same length
        if (s.length() != goal.length()) {
            return false;
        }

        // If goal is a rotation of s, it will appear in s + s
        String doubled = s + s;

        return doubled.contains(goal);
    }
}


Input:
s = "abcde"
goal = "cdeab"

Output:
True

Input:
s = "abcde"
goal = "abced"

Output:
false
