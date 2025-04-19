from typing import List


class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        def P(value):
            left, right = 0, len(nums) - 1
            result = 0

            while left < right:
                cur_sum = nums[left] + nums[right]

                if cur_sum < value:
                    result += right - left
                    left += 1
                else:
                    right -= 1

            return result

        nums.sort()
        return P(upper + 1) - P(lower)
