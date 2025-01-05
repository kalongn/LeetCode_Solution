from typing import List


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for num in asteroids:
            while stack and num < 0 and stack[-1] > 0:
                diff = num + stack[-1]
                if diff < 0:
                    stack.pop()
                elif diff == 0:
                    num = 0
                    stack.pop()
                    break
                else:
                    num = 0
                    break
            if num:
                stack.append(num)

        return stack
