class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        n, result, current_num = len(s), s.count("0"), 0
        for i in range(n):
            if s[n - 1 - i] == "1":
                current_num |= 1 << i
                if current_num > k:
                    break

                result += 1
        return result
