class Solution:
    def maxOperations(self, s: str) -> int:
        count_one = result = i = 0
        while i < len(s):
            if s[i] == "0":
                while i + 1 < len(s) and s[i + 1] == "0":
                    i += 1
                result += count_one
            else:
                count_one += 1
            i += 1
        return result
