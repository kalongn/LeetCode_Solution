from typing import List


class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        count, left = {}, 0
        for right, fruit_type in enumerate(fruits):
            count[fruit_type] = count.get(fruit_type, 0) + 1
            if len(count) > 2:
                count[fruits[left]] -= 1
                if count[fruits[left]] == 0:
                    del count[fruits[left]]
                left += 1
        return right - left + 1
