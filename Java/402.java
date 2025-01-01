import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (stack.size() != 0 && k > 0 && stack.peekFirst() > c) {
                stack.removeFirst();
                k--;
            }
            stack.addFirst(c);
        }
        while (stack.size() != 0 && k > 0) {
            stack.removeFirst();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.removeFirst());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
