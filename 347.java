import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((num1, num2) -> map.get(num1) - map.get(num2));
        for (int i : map.keySet()) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}