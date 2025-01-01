class Solution {
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int i : nums) {
            if (i == 0) {
                return 0;
            }
            if (i < 0) {
                negativeCount++;
            }
        }
        return negativeCount % 2 == 0 ? 1 : -1;
    }
}
