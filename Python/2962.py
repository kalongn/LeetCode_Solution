from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_element = max(nums)
        max_count = result = left = 0

        for right in range(len(nums)):
            if nums[right] == max_element:
                max_count += 1

            while max_count == k:
                if nums[left] == max_element:
                    max_count -= 1
                left += 1

            result += left

        return result
