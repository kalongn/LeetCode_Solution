from typing import List


class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        prefix = [0] * (len(s) + 1)

        for left, right, direction in shifts:
            prefix[right + 1] += 1 if direction else -1
            prefix[left] += -1 if direction else 1

        diff = 0
        result = [ord(c) - ord("a") for c in s]
        for i in reversed(range(len(prefix))):
            diff += prefix[i]
            result[i - 1] = (diff + result[i - 1]) % 26

        result = [chr(c + ord("a")) for c in result]
        return "".join(result)
