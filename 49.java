import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<Integer> charCount = new ArrayList<>(26);
            for (int i = 0; i < 26; i++) {
                charCount.add(0);
            }
            for (int i = 0; i < str.length(); i++) {
                charCount.set(str.charAt(i) - 'a', charCount.get(str.charAt(i) - 'a') + 1);
            }
            List<String> value = map.getOrDefault(charCount, new ArrayList<>());
            value.add(str);
            map.put(charCount, value);
        }
        return map.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
    }
}
