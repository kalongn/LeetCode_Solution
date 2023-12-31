import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] != -1) {
                result = Math.max(result, i - map[s.charAt(i) - 'a'] - 1);
            } else {
                map[s.charAt(i) - 'a'] = i;
            }
        }
        return result;
    }
}
