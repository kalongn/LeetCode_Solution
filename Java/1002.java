import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] globalTracker = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            globalTracker[words[0].charAt(i) - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] localTracker = new int[26];
            for (char c : words[i].toCharArray()) {
                localTracker[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                globalTracker[j] = Math.min(globalTracker[j], localTracker[j]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (globalTracker[i] > 0) {
                for (int j = 0; j < globalTracker[i]; j++) {
                    result.add("" + (char) (i + 'a'));
                }
            }
        }
        return result;
    }
}
