from heapq import heapify, heappop, heappush
from typing import List


class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extraStudents: int) -> float:
        def cal_gain(passes, total):
            return (passes + 1) / (total + 1) - passes / total

        max_heap = []
        for passes, total in classes:
            gain = cal_gain(passes, total)
            max_heap.append((-gain, passes, total))

        heapify(max_heap)

        for _ in range(extraStudents):
            _, passes, total = heappop(max_heap)
            heappush(
                max_heap, (-cal_gain(passes + 1, total + 1), passes + 1, total + 1)
            )

        ratio = sum(passes / total for _, passes, total in max_heap)
        return ratio / len(classes)
