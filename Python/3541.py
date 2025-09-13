from collections import defaultdict


class Solution:
    def maxFreqSum(self, s: str) -> int:
        vowel_count, consonant_count = defaultdict(int), defaultdict(int)
        max_vowel, max_consonant = 0, 0
        for c in s:
            if c in "aeiou":
                vowel_count[c] += 1
                max_vowel = max(max_vowel, vowel_count[c])
            else:
                consonant_count[c] += 1
                max_consonant = max(max_consonant, consonant_count[c])
        print(max_vowel, max_consonant)
        return max_vowel + max_consonant
