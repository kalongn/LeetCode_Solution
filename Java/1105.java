class Solution {
    int dp[];

    public int minHeightShelves(int[][] books, int shelf_width) {
        dp = new int[books.length];
        return dfs(books, 0, shelf_width);
    }

    public int dfs(int[][] books, int idx, int width) {
        if (idx >= books.length) {
            return 0;
        }
        if (dp[idx] != 0) {
            return dp[idx];
        }
        int result = Integer.MAX_VALUE;
        int currw = 0;
        int maxH = books[idx][1];
        for (int i = idx; i < books.length && currw + books[i][0] <= width; i++) {
            maxH = Math.max(maxH, books[i][1]);
            result = Math.min(result, maxH + dfs(books, i + 1, width));
            currw += books[i][0];
        }
        dp[idx] = result;
        return result;
    }
}
