from heapq import heappush, heappop
from typing import List


class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        def sum_of_digits(num):
            result = 0
            while num > 0:
                result += num % 10
                num //= 10
            return result

        dict_temp = dict()  # val -> heap
        for num in nums:
            key = sum_of_digits(num)
            heap = dict_temp.get(key, [])
            heappush(heap, -num)
            dict_temp[key] = heap

        result = -1
        for heap in dict_temp.values():
            if len(heap) < 2:
                continue
            result = max(result, (-heappop(heap)) + (-heappop(heap)))

        return result
