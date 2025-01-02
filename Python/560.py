from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        result = cur_sum = 0
        prefix_sum = {0: 1}

        for num in nums:
            cur_sum += num
            if cur_sum - k in prefix_sum:
                result += prefix_sum[cur_sum - k]

            prefix_sum[cur_sum] = 1 + prefix_sum.get(cur_sum, 0)

        return result
