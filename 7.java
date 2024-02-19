class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        int re = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < re || Integer.MAX_VALUE - re * 10 < (x % 10)) {
                return 0;
            }
            re = re * 10 + (x % 10);
            x = x / 10;
        }
        return re * sign;
    }
}