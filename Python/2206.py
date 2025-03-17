from typing import List


class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        pairs_need = len(nums) // 2
        history = set()

        for i in nums:
            if i not in history:
                history.add(i)
            else:
                pairs_need -= 1
                history.remove(i)

        return pairs_need == 0
