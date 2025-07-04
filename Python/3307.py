from typing import List


class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        result = 0
        k -= 1
        for i in range(k.bit_length() - 1, -1, -1):
            if (k >> i) & 1:
                result += operations[i]

        return chr(ord("a") + (result % 26))
