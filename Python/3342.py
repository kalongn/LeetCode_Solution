from heapq import heappop, heappush
from typing import List


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n = len(moveTime)
        m = len(moveTime[0])

        dp = [[float("inf")] * m for _ in range(n)]
        min_heap = [(0, 0, 0, 1)]
        while min_heap:
            cost, x, y, time = heappop(min_heap)
            if x == n - 1 and y == m - 1:
                continue

            for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
                new_x = x + dx
                new_y = y + dy
                if 0 <= new_x < n and 0 <= new_y < m:
                    new_cost = max(moveTime[new_x][new_y], cost) + time
                    if new_cost < dp[new_x][new_y]:
                        dp[new_x][new_y] = new_cost
                        heappush(min_heap, (new_cost, new_x, new_y, (time % 2) + 1))

        return dp[-1][-1]
