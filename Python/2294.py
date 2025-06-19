from typing import List


class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        result = 1
        begin = nums[0]

        for num in nums:
            if num - begin > k:
                result += 1
                begin = num

        return result
