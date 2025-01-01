import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) {
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>();
        for (char i : t.toCharArray()) {
            mapT.put(i, mapT.getOrDefault(i, 0) + 1);
        }

        int have = 0, needed = mapT.size();
        int maxLength = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, bestLeft = 0;
        for (int right = 0; right < m; right++) {
            char currChar = s.charAt(right);
            window.put(currChar, window.getOrDefault(currChar, 0) + 1);
            if (mapT.containsKey(currChar) && mapT.get(currChar).equals(window.get(currChar))) {
                have++;
            }

            while (have == needed) {
                if ((right - left) + 1 < maxLength) {
                    maxLength = (right - left) + 1;
                    bestLeft = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (mapT.containsKey(leftChar) && window.get(leftChar) < mapT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return maxLength == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLeft + maxLength);
    }
}