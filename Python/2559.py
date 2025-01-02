from typing import List


class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        vowels = {"a", "e", "i", "o", "u"}

        count = [0] * (len(words) + 1)
        for i, word in enumerate(words):
            if word[0] in vowels and word[-1] in vowels:
                count[i + 1] = count[i] + 1
            else:
                count[i + 1] = count[i]

        result = [0] * len(queries)

        for i, query in enumerate(queries):
            result[i] = count[query[1] + 1] - count[query[0]]

        return result
