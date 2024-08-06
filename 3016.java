import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']--;
        }
        Arrays.sort(count);
        int result = 0;
        for (int i = 0; i < 26 && count[i] != 0; i++) {
            result += Math.abs(count[i]) * (i / 8 + 1);
        }
        return result;
    }
}
