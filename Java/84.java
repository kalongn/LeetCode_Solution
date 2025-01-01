import java.util.*;
import javafx.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair<Integer, Integer>> monoStack = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            if (monoStack.isEmpty()) {
                monoStack.push(new Pair<Integer, Integer>(i, heights[i]));
                continue;
            }
            int lastPopIndex = i;
            while (!monoStack.isEmpty() && monoStack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> popped = monoStack.pop();
                lastPopIndex = popped.getKey();
                maxArea = Math.max(maxArea, popped.getValue() * (i - lastPopIndex));
            }
            monoStack.push(new Pair<Integer, Integer>(lastPopIndex, heights[i]));
        }

        while (!monoStack.isEmpty()) {
            Pair<Integer, Integer> popped = monoStack.pop();
            maxArea = Math.max(maxArea, popped.getValue() * (n - popped.getKey()));
        }
        return maxArea;
    }
}
