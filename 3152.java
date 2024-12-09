import java.util.*;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        List<Integer> badIndex = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                badIndex.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            if (bSearch(start + 1, end, badIndex)) {
                result[i] = false;
            } else {
                result[i] = true;
            }
        }

        return result;
    }

    private boolean bSearch(int start, int end, List<Integer> badIndex) {
        int left = 0, right = badIndex.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int bad = badIndex.get(mid);
            if (bad < start) {
                left = mid + 1;
            } else if (bad > end) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}