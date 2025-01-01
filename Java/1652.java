class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }

        int left = 1, right = k, sum = 0;
        if (k < 0) {
            left = code.length - Math.abs(k);
            right = code.length - 1;
        }

        for (int i = left; i <= right; i++) {
            sum += code[i];
        }

        for (int i = 0; i < code.length; i++) {
            result[i] = sum;
            sum -= code[(left) % code.length];
            sum += code[(right + 1) % code.length];

            left++;
            right++;
        }

        return result;
    }
}