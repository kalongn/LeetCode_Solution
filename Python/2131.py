from typing import Counter, List


class Solution:
    def longestPalindrome(self, wordords: List[str]) -> int:
        pairs, symmetric, non_paired = 0, 0, Counter()

        for word in wordords:
            if non_paired[word[::-1]] > 0:
                pairs += 1
                non_paired[word[::-1]] -= 1
                symmetric -= 1 if word[0] == word[1] else 0
            else:
                non_paired[word] += 1
                symmetric += 1 if word[0] == word[1] else 0

        return pairs * 4 + (2 if symmetric > 0 else 0)
