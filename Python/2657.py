from typing import List


class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        n = len(A)
        prefix_result = [0 for _ in range(n)]
        freq = [0 for _ in range(n + 1)]
        common_count = 0

        for i in range(n):
            freq[A[i]] += 1
            if freq[A[i]] == 2:
                common_count += 1

            freq[B[i]] += 1
            if freq[B[i]] == 2:
                common_count += 1

            prefix_result[i] = common_count

        return prefix_result
