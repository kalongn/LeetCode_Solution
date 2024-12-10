import java.util.*;
import javafx.util.Pair;

class Solution {
    public int maximumLength(String s) {
        Map<Pair<Character, Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int rightIndex = i;
            char currentChar = s.charAt(i);
            while (rightIndex < s.length()) {
                if (currentChar != s.charAt(rightIndex)) {
                    break;
                }
                Pair<Character, Integer> pair = new Pair<>(currentChar, rightIndex + 1 - i);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
                rightIndex++;
            }
        }

        int maxLength = -1;
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                maxLength = Math.max(maxLength, entry.getKey().getValue());
            }
        }
        return maxLength;
    }
}