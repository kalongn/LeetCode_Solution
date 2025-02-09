from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        def dfs(i, j, matches):
            if matches == len(word):
                return True
            if (
                i < 0
                or i >= len(board)
                or j < 0
                or j >= len(board[0])
                or board[i][j] != word[matches]
            ):
                return False

            c = board[i][j]
            board[i][j] = ""
            matches += 1
            if (
                dfs(i + 1, j, matches)
                or dfs(i - 1, j, matches)
                or dfs(i, j + 1, matches)
                or dfs(i, j - 1, matches)
            ):
                return True

            board[i][j] = c
            return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0):
                    return True

        return False
