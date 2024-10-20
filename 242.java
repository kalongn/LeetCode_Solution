import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (char i : t.toCharArray()) {
            if (!map.containsKey(i)) {
                return false;
            } else {
                map.put(i, map.get(i) - 1);
            }
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}