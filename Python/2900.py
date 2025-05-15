from typing import List


class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        isOne = groups[0] == 1
        result = [words[0]]
        for i in range(1, len(groups)):
            if (isOne and groups[i] == 0) or ((not isOne) and groups[i] == 1):
                result.append(words[i])
                isOne = not isOne

        return result
