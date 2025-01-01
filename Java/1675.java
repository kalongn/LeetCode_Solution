import java.util.TreeSet;

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                treeSet.add(num * 2);
            } else {
                treeSet.add(num);
            }
        }
        int minDev = treeSet.last() - treeSet.first();
        while (treeSet.last() % 2 == 0) {
            treeSet.add(treeSet.last() / 2);
            treeSet.remove(treeSet.last());
            minDev = Math.min(minDev, treeSet.last() - treeSet.first());
        }
        return minDev;
    }
}