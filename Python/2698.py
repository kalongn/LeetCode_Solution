class Solution:
    def punishmentNumber(self, n: int) -> int:

        def partition(s, i, cur, tgt):
            if i == len(s) and cur == tgt:
                return True

            for j in range(i, len(s)):
                if partition(s, j + 1, cur + int(s[i : j + 1]), tgt):
                    return True

            return False

        result = 0
        for i in range(1, n + 1):
            if partition(str(i * i), 0, 0, i):
                result += i * i
        return result
