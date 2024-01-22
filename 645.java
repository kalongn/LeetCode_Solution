import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        int resultOne = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            sum -= i;
            if (set.contains(i)) {
                resultOne = i;
                continue;
            }
            set.add(i);
        }
        return new int[] { resultOne, resultOne + sum };
    }
}
