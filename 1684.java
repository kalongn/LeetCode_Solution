import java.util.*;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int result = 0;
        boolean exitEarly = false;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    exitEarly = true;
                    break;
                }
            }
            if (!exitEarly) {
                result++;
            } else {
                exitEarly = false;
            }
        }
        return result;
    }
}
