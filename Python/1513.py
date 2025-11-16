class Solution:
    def numSub(self, s: str) -> int:
        cur_ones = result = 0
        s += "0"
        for c in s:
            if c == "1":
                cur_ones += 1
            else:
                result += (cur_ones + 1) * cur_ones // 2
                result %= 10**9 + 7
                cur_ones = 0
        return result
