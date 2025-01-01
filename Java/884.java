import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1Words = s1.split(" ");
        String[] s2Words = s2.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String s1Word : s1Words) {
            map.put(s1Word, map.getOrDefault(s1Word, 0) + 1);
        }
        for (String s2Word : s2Words) {
            map.put(s2Word, map.getOrDefault(s2Word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() == 1) {
                result.add(pair.getKey());
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
