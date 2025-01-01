class Solution {
    public int[] rearrangeArray(int[] nums) {
        int halfOfLength = nums.length / 2;
        int[] less = new int[halfOfLength], high = new int[halfOfLength];
        int negIndex = 0, positiveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                less[negIndex++] = nums[i];
            } else {
                high[positiveIndex++] = nums[i];
            }
        }
        negIndex = 0;
        positiveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? high[positiveIndex++] : less[negIndex++];
        }
        return nums;
    }
}
