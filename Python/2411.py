from typing import List


class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        n = len(nums)
        bit_position = [-1] * 31
        result = [0] * n

        for i in range(n - 1, -1, -1):
            j = i
            for bit in range(31):
                if (nums[i] & (1 << bit)) == 0:
                    if bit_position[bit] != -1:
                        j = max(j, bit_position[bit])
                else:
                    bit_position[bit] = i

            result[i] = j - i + 1

        return result
