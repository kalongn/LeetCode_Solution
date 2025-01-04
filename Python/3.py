class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = {}
        left = 0
        result = 0
        for right in range(len(s)):
            if s[right] in map:
                left = max(map[s[right]] + 1, left)
            map[s[right]] = right
            result = max(result, right - left + 1)

        return result
