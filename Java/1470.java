class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (0 >= n) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return nums;
        }
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[2 * i] = nums[i];
            arr[2 * i + 1] = nums[i + n];
        }
        return arr;
    }
}
