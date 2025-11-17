from typing import List


class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        prev_one = -1
        for i in range(len(nums)):
            if nums[i] == 1:
                if prev_one == -1 or i - prev_one > k:
                    prev_one = i
                else:
                    return False
        return True
