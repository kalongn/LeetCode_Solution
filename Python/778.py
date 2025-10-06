from heapq import heappop, heappush
from typing import List


class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        n = len(grid)
        heap = []
        visited = [[False] * n for _ in range(n)]
        seen_max = float("-inf")

        heappush(heap, (grid[0][0], 0, 0))
        visited[0][0] = True

        while heap:
            height, x, y = heappop(heap)
            seen_max = max(seen_max, height)
            if x == n - 1 and y == n - 1:
                break

            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                    visited[nx][ny] = True
                    heappush(heap, (grid[nx][ny], nx, ny))

        return seen_max
