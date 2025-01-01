import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(result.length());
            } else if (c == ')') {
                reverse(result, stack.pop(), result.length() - 1);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            ++left;
            --right;
        }
    }
}
