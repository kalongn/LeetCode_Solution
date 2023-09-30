import java.util.TreeMap;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        // impossible
        if (n < 3) {
            return false;
        }

        // a self-balancing BST to keep track of numbers and their counts.
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            t.put(nums[i], t.getOrDefault(nums[i], 0) + 1);
        }

        int min_i = Integer.MAX_VALUE;
        for (int j = 1; j < n; j++) {
            min_i = Math.min(min_i, nums[j - 1]);

            // exclude the current nums[j] from the search space
            // if the count is 0, simply discard the node from the BST.
            t.put(nums[j], t.get(nums[j]) - 1);
            if (t.get(nums[j]) == 0) {
                t.remove(nums[j]);
            }

            if (nums[j] < min_i) {
                continue;
            }

            // check if a number, nums[k], exists in the current search space
            // such that min_i < nums[k] < nums[j].
            if (t.subMap(min_i, false, nums[j], false).size() > 0) {
                return true;
            }
        }

        return false;
    }
}
