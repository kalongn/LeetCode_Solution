import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                result += 2;
            } else {
                set.add(c);
            }
        }

        return !set.isEmpty() ? result + 1 : result;
    }
}
