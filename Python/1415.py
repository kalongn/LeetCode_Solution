class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        result = ""

        def backtrack(cur):
            nonlocal k, result
            if len(cur) == n:
                k -= 1
                if k == 0:
                    result = cur
                return

            if result != "":
                return

            for c in ["a", "b", "c"]:
                if len(cur) > 0 and cur[-1] == c:
                    continue

                backtrack(cur + c)
                if result != "":
                    return

        backtrack("")
        return result
