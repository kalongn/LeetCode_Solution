from typing import List


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = []  # (temeprature, index)
        for i, temp in enumerate(temperatures):
            while stack and temp > stack[-1][0]:
                pair = stack.pop()
                result[pair[1]] = i - pair[1]
            stack.append((temp, i))

        return result
