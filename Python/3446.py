from collections import defaultdict
import heapq
from typing import List


class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)
        diag = defaultdict(list)

        for i in range(n):
            for j in range(n):
                key = i - j
                if key < 0:
                    heapq.heappush(diag[key], grid[i][j])
                else:
                    heapq.heappush(diag[key], -grid[i][j])

        for i in range(n):
            for j in range(n):
                key = i - j
                if key < 0:
                    grid[i][j] = heapq.heappop(diag[key])
                else:
                    grid[i][j] = -heapq.heappop(diag[key])

        return grid
