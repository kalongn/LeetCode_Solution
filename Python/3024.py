from typing import List


class Solution:
    def triangleType(self, nums: List[int]) -> str:
        if not (
            (nums[0] + nums[1] > nums[2])
            and (nums[1] + nums[2] > nums[0])
            and (nums[2] + nums[0] > nums[1])
        ):
            return "none"
        match len(set(nums)):
            case 1:
                return "equilateral"
            case 2:
                return "isosceles"
            case _:
                return "scalene"
