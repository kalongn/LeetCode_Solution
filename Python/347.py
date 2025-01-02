from collections import Counter
import heapq
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        result = []
        for key, value in freq.items():
            heapq.heappush(result, (value, key))
            if len(result) > k:
                heapq.heappop(result)

        result = [x for _, x in result]
        return result
