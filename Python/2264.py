class Solution:
    def largestGoodInteger(self, num: str) -> str:
        result = ""
        for i in range(2, len(num)):
            if num[i - 2] == num[i - 1] == num[i]:
                result = max(result, num[i] * 3)
        return result
