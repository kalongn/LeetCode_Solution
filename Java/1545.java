class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int colLength = (int) Math.pow(2, n) - 1;
        int mid = colLength / 2;

        if (k <= mid) {
            return findKthBit(n - 1, k);
        } else if (k == mid + 1) {
            return '1';
        } else {
            k = colLength - k + 1;
            return findKthBit(n - 1, k) == '0' ? '1' : '0';
        }
    }
}
