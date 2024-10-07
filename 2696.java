import java.util.*;

class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char i : s.toCharArray()) {
            if (i == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
            } else if (i == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        return stack.size();
    }
}
