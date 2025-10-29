from math import ceil, log2


class Solution:
    def smallestNumber(self, n: int) -> int:
        return (1 << ceil(log2(n + 1))) - 1
