class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] memo = new int[n + 1][n / 2 + 1];
        return 1 + helper(n, 1, 1, memo);
    }

    private int helper(int n, int currentLength, int pastLength, int[][] memo) {
        if (currentLength == n) {
            return 0;
        }
        if (currentLength > n) {
            return 1000;
        }
        if (memo[currentLength][pastLength] != 0) {
            return memo[currentLength][pastLength];
        }

        int pasteOnly = 1 + helper(n, currentLength + pastLength, pastLength, memo);
        int selectPaste = 2 + helper(n, currentLength * 2, currentLength, memo);
        memo[currentLength][pastLength] = Math.min(pasteOnly, selectPaste);
        return memo[currentLength][pastLength];
    }
}
