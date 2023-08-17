class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1, second = n - 1, entire = m + n - 1;
        while (first >= 0 && second >= 0) {
            nums1[entire--] = nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
        }
        while (second >= 0) {
            nums1[entire--] = nums2[second--];
        }
    }
}
