import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.push(i);
            } else if (c == ')') {
                if (deque.isEmpty()) {
                    chars[i] = '#';
                } else {
                    deque.pop();
                }
            }
        }

        while (!deque.isEmpty()) {
            chars[deque.pop()] = '#';
        }

        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (c != '#') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
