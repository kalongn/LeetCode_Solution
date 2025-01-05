class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        parenthese_map = {")": "(", "}": "{", "]": "["}
        for i in s:
            match i:
                case "(" | "{" | "[":
                    stack.append(i)
                case ")" | "}" | "]":
                    if not stack:
                        return False
                    if stack[-1] != parenthese_map[i]:
                        return False
                    stack.pop()

        return True if not stack else False
