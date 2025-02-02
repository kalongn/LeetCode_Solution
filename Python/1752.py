from typing import List


class Solution:
    def check(self, nums: List[int]) -> bool:
        pivotIndex = 0
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                pivotIndex = i + 1
                break

        for i in range(len(nums) - 1):
            if (
                nums[(pivotIndex + i) % len(nums)]
                > nums[(pivotIndex + i + 1) % len(nums)]
            ):
                return False

        return True
