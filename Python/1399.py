from collections import defaultdict


class Solution:
    def countLargestGroup(self, n: int) -> int:
        count = defaultdict(int)
        max_value = 0
        for i in range(1, n + 1):
            key = sum(int(x) for x in str(i))
            count[key] += 1
            max_value = max(max_value, count[key])
        result = sum(1 for v in count.values() if v == max_value)
        return result
