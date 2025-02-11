class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        stack = []
        for c in s:
            stack.append(c)
            if stack[-1] != part[-1]:
                continue

            i = 0
            while i < len(stack) and i < len(part):
                if stack[-(i + 1)] != part[-(i + 1)]:
                    break
                i += 1

            if i == len(part):
                stack = stack[:-(i)]

        return "".join(stack)
