from heapq import heappop, heappush
from typing import List


class Solution:
    class Cell:
        def __init__(self, height, row, col):
            self.height = height
            self.row = row
            self.col = col

        def __lt__(self, other):
            return self.height < other.height

    def _is_valid_cell(self, row, col, n, m):
        return 0 <= row < n and 0 <= col < m

    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        direction = [(0, -1), (0, 1), (-1, 0), (1, 0)]
        n, m = len(heightMap), len(heightMap[0])

        visited = [[False] * m for _ in range(n)]
        boundary = []

        for i in range(n):
            heappush(boundary, self.Cell(heightMap[i][0], i, 0))
            heappush(boundary, self.Cell(heightMap[i][m - 1], i, m - 1))
            visited[i][0] = visited[i][m - 1] = True

        for i in range(m):
            heappush(boundary, self.Cell(heightMap[0][i], 0, i))
            heappush(boundary, self.Cell(heightMap[n - 1][i], n - 1, i))
            visited[0][i] = visited[n - 1][i] = True

        total_water = 0

        while boundary:
            current_cell = heappop(boundary)

            cur_row = current_cell.row
            cur_col = current_cell.col

            min_boundary_height = current_cell.height

            for dx, dy in direction:
                neighbor_row = cur_row + dx
                neighbor_col = cur_col + dy

                if (
                    self._is_valid_cell(neighbor_row, neighbor_col, n, m)
                    and not visited[neighbor_row][neighbor_col]
                ):
                    neighbor_height = heightMap[neighbor_row][neighbor_col]

                    if neighbor_height < min_boundary_height:
                        total_water += min_boundary_height - neighbor_height

                    heappush(
                        boundary,
                        self.Cell(
                            max(neighbor_height, min_boundary_height),
                            neighbor_row,
                            neighbor_col,
                        ),
                    )

                    visited[neighbor_row][neighbor_col] = True

        return total_water
