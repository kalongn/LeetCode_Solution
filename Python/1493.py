from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        start = zero_count = longest = 0

        for i in range(len(nums)):
            zero_count += 1 if nums[i] == 0 else 0

            while zero_count > 1:
                zero_count -= 1 if nums[start] == 0 else 0
                start += 1

            longest = max(longest, i - start)
        return longest
