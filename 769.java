import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i : arr) {
            if (stack.isEmpty() || i > stack.peek()) {
                stack.push(i);
            } else {
                int max = stack.peek();
                while (!stack.isEmpty() && i < stack.peek()) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}