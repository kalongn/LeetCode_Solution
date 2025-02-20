from typing import List


class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        result = []
        for i in range(len(nums)):
            c = nums[i][i]
            result.append("1" if c == "0" else "0")

        return "".join(result)
