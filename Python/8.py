class Solution:
    def myAtoi(self, s: str) -> int:
        signs = {"-": -1, "+": 1}
        sign = 1
        result = 0
        left = 0

        while left < len(s) and s[left] == " ":
            left += 1

        if left < len(s) and s[left] in signs:
            sign = signs[s[left]]
            left += 1

        while left < len(s) and s[left].isdigit():
            result = (result * 10) + int(s[left])
            left += 1

        result *= sign
        if result >= 2**31 - 1:
            return 2**31 - 1
        elif result <= -(2**31):
            return -(2**31)

        return result
