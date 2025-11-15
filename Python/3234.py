class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        n = len(s)
        prev_zero = [-1] * (n + 1)

        for i in range(n):
            if i == 0 or s[i - 1] == "0":
                prev_zero[i + 1] = i
            else:
                prev_zero[i + 1] = prev_zero[i]

        result = 0

        for i in range(1, n + 1):
            count_zero = 1 if s[i - 1] == "0" else 0
            j = i
            while j > 0 and count_zero * count_zero <= n:
                count_one = (i - prev_zero[j]) - count_zero
                if count_zero * count_zero <= count_one:
                    result += min(
                        j - prev_zero[j], count_one - count_zero * count_zero + 1
                    )
                j = prev_zero[j]
                count_zero += 1

        return result
