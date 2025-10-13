from typing import List


class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        stack = []
        for word in words:
            if not stack:
                stack.append(word)
                continue
            if sorted(stack[-1]) == sorted(word):
                continue
            stack.append(word)
        return stack
