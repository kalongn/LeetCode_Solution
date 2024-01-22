class Solution {
    public int rob(int[] nums) {
        int rob = 0, notRob = 0;
        for (int i = 0; i < nums.length; i++) {
            int ifRob = notRob + nums[i];
            notRob = Math.max(notRob, rob);
            rob = ifRob;
        }
        return Math.max(rob, notRob);
    }
}
