class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        for step in path.split("/"):
            match step:
                case "" | ".":
                    continue
                case "..":
                    if stack:
                        stack.pop()
                case _:
                    stack.append(step)

        return "/" + "/".join(stack)
