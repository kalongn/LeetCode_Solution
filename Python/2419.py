from typing import List


class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        max_val = result = consecutive_count = 0
        for num in nums:
            if max_val < num:
                max_val = num
                result = consecutive_count = 0

            if max_val == num:
                consecutive_count += 1
            else:
                consecutive_count = 0

            result = max(result, consecutive_count)

        return result
