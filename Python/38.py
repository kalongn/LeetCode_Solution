class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        prev = self.countAndSay(n - 1)
        result = ""
        count = 1
        digit = prev[0]
        for i in range(1, len(prev)):
            if prev[i] == digit:
                count += 1
            else:
                result += str(count) + digit
                count = 1
                digit = prev[i]
        result += str(count) + digit
        return result
