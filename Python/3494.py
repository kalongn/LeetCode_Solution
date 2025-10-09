from itertools import accumulate
from typing import List


class Solution:
    def minTime(self, skill: List[int], mana: List[int]) -> int:
        prefix = list(accumulate(skill, initial=0))
        start_time = 0
        for j in range(1, len(mana)):
            max_start_next = 0
            for i in range(len(skill)):
                finish_current = start_time + mana[j - 1] * prefix[i + 1]
                start_next = finish_current - mana[j] * prefix[i]
                max_start_next = max(max_start_next, start_next)
            start_time = max_start_next
        return start_time + prefix[-1] * mana[-1]
