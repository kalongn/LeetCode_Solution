class Solution {

    private boolean canDistributed(int x, int n, int[] quantities) {
        int stores = 0;
        for (int i : quantities) {
            stores += (int) Math.ceil((double) i / x);
        }
        return stores <= n;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int i : quantities) {
            max = Math.max(max, i);
        }
        int left = 1, right = max;
        int result = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (canDistributed(middle, n, quantities)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }
}
