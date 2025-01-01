import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] numsToString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsToString[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsToString, (a, b) -> (b + a).compareTo(a + b));
        return numsToString[0].equals("0") ? "0" : String.join("", numsToString);
    }
}
