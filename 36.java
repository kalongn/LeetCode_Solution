class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] squCheck = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int q = (r / 3) * 3 + c / 3;
                int val = board[r][c] - '1';
                if (rowCheck[r][val] || colCheck[c][val] || squCheck[q][val]) {
                    return false;
                }
                rowCheck[r][val] = true;
                colCheck[c][val] = true;
                squCheck[q][val] = true;
            }
        }
        return true;
    }
}