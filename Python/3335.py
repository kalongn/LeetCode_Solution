class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        MOD = 10**9 + 7
        count = [0] * 26
        for c in s:
            count[ord(c) - ord("a")] += 1
        for round in range(t):
            next = [0] * 26
            next[0] = count[25]
            next[1] = (count[25] + count[0]) % MOD
            for i in range(2, 26):
                next[i] = count[i - 1]
            count = next
        result = sum(count) % MOD
        return result
