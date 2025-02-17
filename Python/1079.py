class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        result = set()
        used = [False] * len(tiles)

        def backtracking(current):
            result.add(current)

            for pos, char in enumerate(tiles):
                if not used[pos]:
                    used[pos] = True
                    backtracking(current + char)
                    used[pos] = False

        backtracking("")
        return len(result) - 1
