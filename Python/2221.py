from typing import List


class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n - 1, -1, -1):
            for j in range(i):
                nums[j] = (nums[j] + nums[j + 1]) % 10
        return nums[0]
