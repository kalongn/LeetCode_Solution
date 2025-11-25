class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        seen_remainder = set()
        remainder = 1 % k
        result = 1
        while remainder != 0 and remainder not in seen_remainder:
            seen_remainder.add(remainder)
            remainder = (10 * remainder + 1) % k
            result += 1

        return result if remainder == 0 else -1
