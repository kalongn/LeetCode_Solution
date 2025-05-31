from collections import deque
from typing import List


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        start, end = 1, n * n
        visited = set()
        queue = deque()
        queue.append((start, 0))  # initial state before throwing dice

        # the purpose of this function is to give row and column value of a cell after adding a move comes on dice
        def find_coordinates(current_position):
            row = (
                n - 1 - (current_position - 1) // n
            )  # normal calculation to find row number of a cell
            col = (
                current_position - 1
            ) % n  # normal calculation to find column number of a cell
            if (
                row % 2 == n % 2
            ):  # board is in  Boustrophedon style so handle it we are checking this condition
                return (row, n - 1 - col)
            else:
                return (row, col)

        while queue:
            curr_pos, steps = queue.popleft()
            if curr_pos == end:  # when player reaches at end, return steps
                return steps

            for dice in range(1, 7):  # iterating on all numbers of dices
                if curr_pos + dice > end:  # not valid position to move
                    break
                next_row, next_col = find_coordinates(
                    curr_pos + dice
                )  # got coordinates of row and column
                if (
                    next_row,
                    next_col,
                ) not in visited:  # checking that cell is already not visited
                    visited.add((next_row, next_col))
                    if board[next_row][next_col] != -1:  # if there is ladder
                        queue.append((board[next_row][next_col], steps + 1))
                    else:
                        queue.append((curr_pos + dice, steps + 1))
        return -1
