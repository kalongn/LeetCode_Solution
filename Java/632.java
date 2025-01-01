import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int maxVal = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int currentVal = nums.get(i).get(0);
            heap.offer(new Triplet(currentVal, i, 0));
            maxVal = Math.max(maxVal, currentVal);
        }

        while (heap.size() == nums.size()) {
            Triplet currentMin = heap.poll();
            int minVal = currentMin.val, listIndex = currentMin.listIndex, index = currentMin.index;

            if (maxVal - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = maxVal;
            }

            if (index + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(index + 1);
                heap.offer(new Triplet(nextVal, listIndex, index + 1));
                maxVal = Math.max(maxVal, nextVal);
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }
}

class Triplet {
    int val, listIndex, index;

    Triplet(int val, int listIndex, int index) {
        this.val = val;
        this.listIndex = listIndex;
        this.index = index;
    }
}
