from collections import Counter


class Solution:
    def robotWithString(self, s: str) -> str:
        count = Counter(s)
        stack = []
        result = []

        minCharacter = "a"

        for char in s:
            stack.append(char)
            count[char] -= 1
            while minCharacter != "z" and count[minCharacter] == 0:
                minCharacter = chr(ord(minCharacter) + 1)
            while stack and stack[-1] <= minCharacter:
                result.append(stack.pop())

        return "".join(result)
