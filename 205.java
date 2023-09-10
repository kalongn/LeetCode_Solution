import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (map.containsKey(sArray[i])) {
                if (map.get(sArray[i]).equals(tArray[i])) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(tArray[i])) {
                    map.put(sArray[i], tArray[i]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
