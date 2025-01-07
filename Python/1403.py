from typing import List


class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        result = []
        for word in words:
            for other_words in words:
                if word in other_words and word != other_words:
                    result.append(word)
                    break

        return result
