from typing import List


class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda interval: (interval[1], interval[0]))
        result = [intervals[0][1] - 1, intervals[0][1]]

        for i in range(1, len(intervals)):
            start = intervals[i][0]
            end = intervals[i][1]

            prev_largest = result[-1]
            prev_second_largest = result[-2]

            if start > prev_largest:
                result += [end - 1, end]
            elif start == prev_largest or start > prev_second_largest:
                result.append(end)

        return len(result)
