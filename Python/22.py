from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        current = []

        def backtrack(open, close):
            if open == close == n:
                result.append("".join(current))
                return
            if open < n or open == close:
                current.append("(")
                backtrack(open + 1, close)
                current.pop()
            if open > close:
                current.append(")")
                backtrack(open, close + 1)
                current.pop()

        backtrack(0, 0)
        return result
