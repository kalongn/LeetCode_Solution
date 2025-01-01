class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length, left = 1, right = n - 2;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}
