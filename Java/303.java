class NumArray {
    int[] arr;
    int[] num;

    public NumArray(int[] nums) {
        int sum = 0;
        num = nums;
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return arr[right] - arr[left] + num[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
