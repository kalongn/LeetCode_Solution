from collections import defaultdict
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        count = defaultdict(int)

        for num in nums:
            count[num] += 1

            if len(count) <= 2:
                continue

            new_count = defaultdict(int)
            for num, count in count.items():
                if count > 1:
                    new_count[num] = count - 1
            count = new_count

        result = []
        for num in count:
            if nums.count(num) > len(nums) // 3:
                result.append(num)

        return result
