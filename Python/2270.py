from typing import List


class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        result = 0

        # prefixSum = [0] * len(nums)
        # prefixSum[0] = nums[0]

        # for i in range(1, len(nums)):
        #     prefixSum[i] = prefixSum[i - 1] + nums[i]

        # result = 0
        # for i in range(0, len(nums) - 1):
        #     before = prefixSum[i]
        #     after = prefixSum[len(nums) - 1] - prefixSum[i]
        #     if before >= after:
        #         result += 1

        left, right = 0, sum(nums)
        for i in range(len(nums) - 1):
            left += nums[i]
            right -= nums[i]

            result += 1 if left >= right else 0

        return result
