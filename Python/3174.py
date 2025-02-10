class Solution:
    def clearDigits(self, s: str) -> str:
        j, s = 0, list(s)
        for i, c in enumerate(s):
            if c.isdigit():
                j = max(j - 1, 0)
            else:
                s[j] = s[i]
                j += 1
        return "".join(s[:j])
