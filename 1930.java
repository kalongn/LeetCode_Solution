import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        int last[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            first[ch - 'a'] = Math.min(first[ch - 'a'], i);
            last[ch - 'a'] = i;
        }

        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (first[i] != Integer.MAX_VALUE && (last[i] - first[i]) > 1) {
                set.clear();
                for (int j = first[i] + 1; j < last[i]; j++) {
                    set.add(s.charAt(j));
                }
                res += set.size();
            }
        }
        return res;
    }
}
