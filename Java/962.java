import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> indicesStack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i);
            }
        }

        int maxWidth = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, i - indicesStack.peek());
                indicesStack.pop();
            }
        }

        return maxWidth;
    }
}
