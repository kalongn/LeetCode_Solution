import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> resultMap = new HashMap<>();
        for (String i : strs) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : i.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<String> list = resultMap.getOrDefault(map, new ArrayList<String>());
            list.add(i);
            resultMap.put(map, list);
        }
        List<List<String>> result = new LinkedList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> pair : resultMap.entrySet()) {
            result.add(pair.getValue());
        }
        return result;
    }
}