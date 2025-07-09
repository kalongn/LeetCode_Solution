from typing import List


class Solution:
    def maxFreeTime(
        self, eventTime: int, k: int, startTime: List[int], endTime: List[int]
    ) -> int:
        n = len(startTime)
        result = 0
        cur_total = 0

        for i in range(n):
            cur_total += endTime[i] - startTime[i]

            left = 0 if i <= k - 1 else endTime[i - k]
            right = eventTime if i == n - 1 else startTime[i + 1]

            result = max(result, right - left - cur_total)

            if i >= k - 1:
                cur_total -= endTime[i - k + 1] - startTime[i - k + 1]

        return result
