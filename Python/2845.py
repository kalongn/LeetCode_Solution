from typing import Counter, List


class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        n = len(nums)
        result = prefix = 0
        count = Counter([0])

        for i in range(n):
            prefix += 1 if nums[i] % modulo == k else 0
            result += count[(prefix - k + modulo) % modulo]
            count[prefix % modulo] += 1

        return result
