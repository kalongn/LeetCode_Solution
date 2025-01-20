from typing import List


class Solution:
    def firstCompleteIndex(self, arr: List[int], mat: List[List[int]]) -> int:
        rows = [0] * len(mat)
        cols = [0] * len(mat[0])

        mat_map = dict()
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                cur = mat[i][j]
                mat_map[cur] = (i, j)

        for i, num in enumerate(arr):
            if num not in mat_map:
                continue

            row_i, col_i = mat_map[num]
            rows[row_i] += 1
            cols[col_i] += 1

            if rows[row_i] == len(mat[0]) or cols[col_i] == len(mat):
                return i

        return -1
