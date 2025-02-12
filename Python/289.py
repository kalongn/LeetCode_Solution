from typing import List


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ## APPRAOCH : IN-PLACE MANIPULATION ##
        #  when the value needs to be updated, we donot just change  0 to 1 / 1 to 0 but we do in increments and decrements of 2. (table explains)
        ##   previous value state change  current state   current value
        ##   0              no change     dead            0
        ##   1              no change     live            1
        ##   0              changed (+2)  live            2
        ##   1              changed (-2)  dead            -1

        directions = [
            (1, 0),
            (1, -1),
            (0, -1),
            (-1, -1),
            (-1, 0),
            (-1, 1),
            (0, 1),
            (1, 1),
        ]

        for i in range(len(board)):
            for j in range(len(board[0])):
                live = 0
                for x, y in directions:
                    if (
                        0 <= i + x < len(board)
                        and 0 <= j + y < len(board[0])
                        and abs(board[i + x][j + y]) == 1
                    ):
                        live += 1

                if board[i][j] == 1 and (live < 2 or live > 3):
                    board[i][j] = -1
                elif board[i][j] == 0 and live == 3:
                    board[i][j] = 2

        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = 1 if (board[i][j] > 0) else 0

        return board
