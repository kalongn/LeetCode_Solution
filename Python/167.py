from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers) - 1
        cur_sum = numbers[left] + numbers[right]

        while cur_sum != target:
            if cur_sum > target:
                right -= 1
            else:
                left += 1
            cur_sum = numbers[left] + numbers[right]

        return [left + 1, right + 1]
