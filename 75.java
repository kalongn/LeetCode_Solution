class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i] > 0) {
                nums[index] = i;
                index++;
                count[i]--;
            }
        }
    }
}
