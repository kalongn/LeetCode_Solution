class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int beg = 1;

        while (n > 0) {
            for (int i = 0; i < Math.min(n, 7); i++) {
                result += beg + i;
            }
            n -= 7;
            beg++;
        }

        return result;
    }
}
