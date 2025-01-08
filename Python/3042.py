from typing import List


class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        result = 0
        for i in range(len(words) - 1):
            for j in range(i + 1, len(words)):
                if (
                    len(words[j]) >= len(words[i])
                    and words[j][0 : len(words[i])] == words[i]
                    and words[j][-1 * len(words[i]) :] == words[i]
                ):
                    result += 1

        return result
