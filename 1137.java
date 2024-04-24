class Solution {
    public int tribonacci(int n) {
        int[] result = new int[3];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;
        if (n < 3) {
            return result[n];
        }
        for (int i = 3; i <= n; i++) {
            result[i % 3] = result[0] + result[1] + result[2];
        }
        return result[n % 3];
    }
}
