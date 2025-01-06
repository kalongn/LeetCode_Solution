from typing import List


class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def feasible(largest):
            cur_sum = 0
            required = 1
            for i in nums:
                cur_sum += i
                if cur_sum > largest:
                    required += 1
                    if required > k:
                        return False
                    cur_sum = i
            return True

        left, right = max(nums), sum(nums)
        result = right
        while left <= right:
            mid = left + (right - left) // 2
            if feasible(mid):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result
