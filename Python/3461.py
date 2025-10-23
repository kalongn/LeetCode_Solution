class Solution:
    def hasSameDigits(self, s: str) -> bool:
        n = len(s)
        s_list = list(s)
        for i in range(1, n - 1):
            for j in range(n - i):
                digit_one = int(s_list[j])
                digit_two = int(s_list[j + 1])

                s_list[j] = str((digit_one + digit_two) % 10)
        return s_list[0] == s_list[1]
