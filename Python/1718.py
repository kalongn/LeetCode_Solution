from typing import List


class Solution:
    def constructDistancedSequence(self, n: int) -> List[int]:
        result = [0] * (n * 2 - 1)
        visited = [False] * (n + 1)

        def dfs(index):
            if index == len(result):
                return True

            if result[index] != 0:
                return dfs(index + 1)

            for num in range(n, 0, -1):
                if visited[num]:
                    continue

                visited[num] = True
                result[index] = num

                if num == 1 and dfs(index + 1):
                    return True
                elif index + num < len(result) and result[index + num] == 0:
                    result[index + num] = num
                    if dfs(index + 1):
                        return True
                    result[index + num] = 0

                visited[num] = False
                result[index] = 0

            return False

        dfs(0)
        return result
