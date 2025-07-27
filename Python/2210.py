from typing import List


class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        result = left = 0

        for right in range(1, len(nums) - 1):
            if nums[right] != nums[right + 1]:
                if (nums[right] > nums[left] and nums[right] > nums[right + 1]) or (
                    nums[right] < nums[left] and nums[right] < nums[right + 1]
                ):
                    result += 1

                left = right

        return result
