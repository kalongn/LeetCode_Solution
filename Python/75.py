from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        freq = [0] * 3
        for num in nums:
            freq[num] += 1

        index = 0
        for i, f in enumerate(freq):
            for _ in range(f):
                nums[index] = i
                index += 1
