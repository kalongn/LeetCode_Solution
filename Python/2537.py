from collections import defaultdict
from typing import List


class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        left = result = same = 0
        n, counter = len(nums), defaultdict(int)

        for right, num in enumerate(nums):
            same += counter[num]
            counter[num] += 1

            while same >= k:
                result += n - right
                counter[nums[left]] -= 1
                same -= counter[nums[left]]
                left += 1

        return result
