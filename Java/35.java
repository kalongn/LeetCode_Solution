class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length - 1, target, nums);
    }

    private int binarySearch(int begin, int end, int target, int[] nums) {
        if (end >= begin) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(begin, mid - 1, target, nums);
            } else if (nums[mid] < target) {
                return binarySearch(mid + 1, end, target, nums);
            }
        }
        return begin;
    }
}
