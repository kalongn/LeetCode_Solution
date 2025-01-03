from typing import List


class Solution:
    def mystery(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n

        def reverse(begin, end):
            while begin < end:
                nums[begin], nums[end] = nums[end], nums[begin]
                begin += 1
                end -= 1

        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)
