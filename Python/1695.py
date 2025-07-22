from typing import List


class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        seen = set()
        result = win_sum = 0
        left = 0
        for right in range(len(nums)):
            cur_num = nums[right]
            while left < right and cur_num in seen:
                seen.remove(nums[left])
                win_sum -= nums[left]
                left += 1
            win_sum += cur_num
            seen.add(cur_num)
            result = max(result, win_sum)

        return result
