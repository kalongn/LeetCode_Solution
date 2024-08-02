class Solution {
    public int minSwaps(int[] nums) {
        int totalOfOne = 0;
        for (int i : nums) {
            if (i == 1) {
                totalOfOne++;
            }
        }
        int[] numCirs = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            numCirs[i] = nums[i];
            numCirs[nums.length + i] = nums[i];
        }
        int amtOfZero = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < totalOfOne; i++) {
            if (numCirs[i] == 0) {
                amtOfZero++;
            }
        }
        result = Math.min(result, amtOfZero);
        for (int i = totalOfOne; i < numCirs.length; i++) {
            if (numCirs[i - totalOfOne] == 0) {
                amtOfZero--;
            }
            if (numCirs[i] == 0) {
                amtOfZero++;
            }
            result = Math.min(result, amtOfZero);
        }
        return result;
    }
}
