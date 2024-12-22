import java.util.*;
import javafx.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<List<Pair<Integer, Integer>>> groups = new ArrayList<>(queries.length);
        for (int i = 0; i < heights.length; i++) {
            groups.add(new ArrayList<>());
        }
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        int index = 0;
        for (int[] query : queries) {
            if (query[1] < query[0]) {
                int temp = query[1];
                query[1] = query[0];
                query[0] = temp;
            }

            int x = query[0], y = query[1];
            if (x == y || heights[x] < heights[y]) {
                result[index] = y;
            } else {
                int maxHeight = Math.max(heights[x], heights[y]);
                groups.get(y).add(new Pair<>(maxHeight, index));
            }
            index++;
        }

        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
                (x, y) -> Integer.compare(x.getKey(), y.getKey()) == 0 ? Integer.compare(x.getValue(), y.getValue())
                        : Integer.compare(x.getKey(), y.getKey()));

        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];

            for (Pair<Integer, Integer> pair : groups.get(i)) {
                minHeap.add(pair);
            }

            while (!minHeap.isEmpty() && currentHeight > minHeap.peek().getKey()) {
                Pair<Integer, Integer> pair = minHeap.poll();
                result[pair.getValue()] = i;
            }
        }

        return result;
    }
}