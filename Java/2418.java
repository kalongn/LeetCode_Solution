import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Queue<Pair<String, Integer>> heap = new PriorityQueue<>(
                (a, b) -> -1 * Integer.compare(a.getValue​(), b.getValue()));
        for (int i = 0; i < names.length; i++) {
            heap.add(new Pair(names[i], heights[i]));
        }
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}