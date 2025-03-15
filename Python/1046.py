import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = [-x for x in stones]
        heapq.heapify(heap)

        while len(heap) >= 2:
            s1 = -1 * heapq.heappop(heap)
            s2 = -1 * heapq.heappop(heap)
            if s1 == s2:
                continue
            else:
                heapq.heappush(heap, -1 * abs(s1 - s2))

        return 0 if len(heap) == 0 else -1 * heap[0]
