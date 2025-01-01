class Solution {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)
                || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(board, i + 1, j, index + 1, word) ||
                dfs(board, i - 1, j, index + 1, word) ||
                dfs(board, i, j + 1, index + 1, word) ||
                dfs(board, i, j - 1, index + 1, word);

        visited[i][j] = false;
        return found;
    }
}
