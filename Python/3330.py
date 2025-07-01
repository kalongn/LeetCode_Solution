class Solution:
    def possibleStringCount(self, word: str) -> int:
        n, result = len(word), 1
        for i in range(1, n):
            if word[i - 1] == word[i]:
                result += 1

        return result
