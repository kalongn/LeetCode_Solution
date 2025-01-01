import java.util.*;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(num);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }
        List<Integer> smallestFour = new ArrayList<>(maxHeap);
        List<Integer> largestFour = new ArrayList<>(minHeap);
        Collections.sort(smallestFour);
        Collections.sort(largestFour);

        int resultDiff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            resultDiff = Math.min(resultDiff, largestFour.get(i) - smallestFour.get(i));
        }
        return resultDiff;
    }
}