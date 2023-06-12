import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int begin = nums[0];
        boolean end = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                end = true;
                continue;
            } else if (end) {
                result.add("" + begin + "->" + nums[i - 1]);
            } else {
                result.add("" + begin);
            }
            begin = nums[i];
            end = false;
        }
        String last = end ? "" + begin + "->" + nums[nums.length - 1] : "" + begin;
        result.add(last);
        return result;
    }
}