import heapq
from typing import List


class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n = len(moveTime)
        m = len(moveTime[0])

        min_heap = [(0, 0, 0)]  # (cur_time, x, y)
        arrival_time = [[float("inf")] * m for _ in range(n)]
        arrival_time[0][0] = 0

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        while min_heap:
            cur_time, x, y = heapq.heappop(min_heap)

            if (x, y) == (n - 1, m - 1):
                return cur_time

            for dx, dy in directions:
                new_x, new_y = x + dx, y + dy

                if 0 <= new_x < n and 0 <= new_y < m:
                    wait_time = max(moveTime[new_x][new_y] - cur_time, 0)
                    new_arrival_time = cur_time + 1 + wait_time

                    if new_arrival_time < arrival_time[new_x][new_y]:
                        arrival_time[new_x][new_y] = new_arrival_time
                        heapq.heappush(min_heap, (new_arrival_time, new_x, new_y))

        return -1
