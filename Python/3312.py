from typing import List
from collections import Counter
from sortedcontainers import SortedList


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        top, bottom = SortedList(), SortedList()
        freq = Counter()
        cur_sum = 0

        def update(x, is_add):
            nonlocal cur_sum
            temp = [freq[x], x]
            if freq[x]:
                if temp in bottom:
                    bottom.remove(temp)
                else:
                    top.remove(temp)
                    cur_sum -= freq[x] * x
            freq[x] += 1 if is_add else -1
            if freq[x]:
                bottom.add([freq[x], x])

        result = []
        for i in range(len(nums)):
            update(nums[i], True)
            if i >= k:
                update(nums[i - k], False)

            while bottom and len(top) < x:
                count_x, num_x = bottom.pop()
                cur_sum += count_x * num_x
                top.add([count_x, num_x])

            while bottom and bottom[-1] > top[0]:
                count_x, num_x = bottom.pop()
                count_y, num_y = top.pop(0)
                cur_sum += count_x * num_x - count_y * num_y
                bottom.add([count_y, num_y])
                top.add([count_x, num_x])

            if i >= k - 1:
                result.append(cur_sum)

        return result
