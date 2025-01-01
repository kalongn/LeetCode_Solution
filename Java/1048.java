import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int result = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();

        for (String i : words) {
            map.put(i, 1);

            for (int j = 0; j < i.length(); j++) {
                StringBuilder sb = new StringBuilder(i);
                String next = sb.deleteCharAt(j).toString();

                if (map.containsKey(next) && map.get(next) + 1 > map.get(i)) {
                    map.put(i, map.get(next) + 1);
                }
            }
            result = Math.max(result, map.get(i));
        }
        return result;
    }
}
