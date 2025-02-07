from typing import List


class Solution:
    def queryResults(self, limit: int, queries: List[List[int]]) -> List[int]:
        colors = dict()  # color -> count
        balls = dict()  # ball -> color
        result = [0] * len(queries)

        for i, [x, y] in enumerate(queries):
            if x in balls:
                colors[balls[x]] -= 1
                if colors[balls[x]] == 0:
                    del colors[balls[x]]
            balls[x] = y
            colors[y] = colors.get(y, 0) + 1
            result[i] = len(colors)

        return result
