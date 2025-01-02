from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = dict()
        for i, num in enumerate(nums):
            remain = target - num
            if remain in map:
                return [i, map[remain]]
            map[num] = i
        return [-1, -1]
