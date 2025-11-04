from heapq import nlargest
from typing import Counter, List


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        def x_sum(i):
            freq = Counter(nums[i : i + k])
            most_freq = nlargest(x, freq, key=lambda num: (freq[num], num))
            return sum(map(lambda num: num * freq[num], most_freq))

        return list(map(x_sum, range(len(nums) - k + 1)))
