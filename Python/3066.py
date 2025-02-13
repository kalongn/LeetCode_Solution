from heapq import heapify, heappop, heappush
from typing import List


class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        heap = nums
        heapify(heap)

        result = 0
        while len(nums) >= 2:
            if heap[0] >= k:
                return result
            val_one = heappop(heap)
            val_two = heappop(heap)
            heappush(heap, min(val_one, val_two) * 2 + max(val_one, val_two))
            result += 1

        return result
