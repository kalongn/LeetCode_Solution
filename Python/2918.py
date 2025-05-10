from typing import List


class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        sum1 = sum2 = 0
        zero1 = zero2 = 0

        for num1 in nums1:
            sum1 += num1
            if num1 == 0:
                sum1 += 1
                zero1 += 1

        for num2 in nums2:
            sum2 += num2
            if num2 == 0:
                sum2 += 1
                zero2 += 1

        if (zero1 == 0 and sum2 > sum1) or (zero2 == 0 and sum1 > sum2):
            return -1

        return max(sum1, sum2)
