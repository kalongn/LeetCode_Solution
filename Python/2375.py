class Solution:
    def smallestNumber(self, pattern: str) -> str:
        result = []
        num_stack = []

        for i in range(len(pattern) + 1):
            num_stack.append(i + 1)

            if i == len(pattern) or pattern[i] == "I":
                while num_stack:
                    result.append(str(num_stack.pop()))

        return "".join(result)
