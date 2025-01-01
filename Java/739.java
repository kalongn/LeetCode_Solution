import java.util.*;
import javafx.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair<Integer, Integer>> monoStack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && temperatures[i] > monoStack.peek().getValue()) {
                Pair<Integer, Integer> prevDay = monoStack.pop();
                result[prevDay.getKey()] = i - prevDay.getKey();
            }
            monoStack.push(new Pair<Integer, Integer>(i, temperatures[i]));
        }
        return result;
    }
}