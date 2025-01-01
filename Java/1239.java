import java.util.*;

class Solution {
    int max = 0;

    public int maxLength(List<String> arr) {
        backTrack(arr, "", 0);
        return max;
    }

    private void backTrack(List<String> arr, String current, int start) {
        if (max < current.length()) {
            max = current.length();
        }
        for (int i = start; i < arr.size(); i++) {
            if (!isValid(current, arr.get(i))) {
                continue;
            }
            backTrack(arr, current + arr.get(i), i + 1);
        }
    }

    private boolean isValid(String currentString, String newString) {
        boolean[] array = new boolean[26];
        for (int i = 0; i < newString.length(); i++) {
            char c = newString.charAt(i);
            if (array[c - 'a'] || currentString.indexOf(c) != -1) {
                return false;
            }
            array[c - 'a'] = true;
        }
        return true;
    }
}
