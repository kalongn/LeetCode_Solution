class Solution {
    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {

        int[] freq = new int[k];
        backtrack(cookies, freq, 0, k);

        return ans;
    }

    private void backtrack(int[] cookies, int[] freq, int start, int k) {
        if (start == cookies.length) {
            int max = 0;
            for (int f : freq) {
                max = Math.max(f, max);
            }
            ans = Math.min(ans, max);
            return;
        }

        for (int i = 0; i < k; i++) {
            freq[i] += cookies[start];
            backtrack(cookies, freq, start + 1, k);
            freq[i] -= cookies[start];
            if (freq[i] == 0)
                break;
        }
    }
}