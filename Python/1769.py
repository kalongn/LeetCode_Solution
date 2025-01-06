from typing import List


class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        answer = [0] * len(boxes)

        cur_balls, cur_moves = 0, 0
        for i, c in enumerate(boxes):
            answer[i] = cur_balls + cur_moves
            cur_moves += cur_balls
            if c == "1":
                cur_balls += 1

        cur_balls, cur_moves = 0, 0
        for i, c in reversed(list(enumerate(boxes))):
            answer[i] += cur_balls + cur_moves
            cur_moves += cur_balls
            if c == "1":
                cur_balls += 1

        return answer
