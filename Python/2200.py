from typing import List


class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        result = []
        n, min_right = len(nums), 0

        for right in range(n):
            if nums[right] == key:
                left = max(min_right, right - k)
                min_right = min(n - 1, right + k) + 1
                for i in range(left, min_right):
                    result.append(i)
        return result
