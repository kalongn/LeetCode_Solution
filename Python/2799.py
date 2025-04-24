from typing import Counter, List


class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        n, k = len(nums), len(set(nums))
        result = left = 0
        count = Counter()
        for right in range(n):
            count[nums[right]] += 1
            while len(count) == k:
                count[nums[left]] -= 1
                if count[nums[left]] == 0:
                    del count[nums[left]]
                left += 1
            result += left
        return result
