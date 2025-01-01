import java.util.*;

class Solution {
    public String customSortString(String order, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }
        String result = "";

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (!map.containsKey(ch)) {
                continue;
            }
            int freq = map.get(ch);
            for (int j = 0; j < freq; j++) {
                result += Character.toString(ch);
            }
            map.remove(ch);
        }

        for (Character key : map.keySet()) {
            int freq = map.get(key);
            for (int j = 0; j < freq; j++) {
                result += Character.toString(key);
            }
        }
        return result;
    }
}