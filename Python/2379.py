class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        black_count = 0
        for i in range(k):
            if blocks[i] == "B":
                black_count += 1

        result = k - black_count
        if result == 0:
            return result

        for i in range(k, len(blocks)):
            if blocks[i - k] == "B":
                black_count -= 1
            if blocks[i] == "B":
                black_count += 1
            result = min(result, k - black_count)

        return result
