from typing import List


class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        min_in_interval = max_in_interval = interval_sum = 0
        for difference in differences:
            interval_sum += difference
            min_in_interval = min(min_in_interval, interval_sum)
            max_in_interval = max(max_in_interval, interval_sum)
            if max_in_interval - min_in_interval > upper - lower:
                return 0

        return (upper - lower) - (max_in_interval - min_in_interval) + 1
