from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freq = defaultdict(int)
        max_char_count = 0
        result = 0
        left = 0
        for right in range(len(s)):
            freq[s[right]] += 1
            max_char_count = max(max_char_count, freq[s[right]])

            if right - left + 1 - max_char_count > k:
                freq[s[left]] -= 1
                left += 1

            result = max(result, right - left + 1)
        return result
