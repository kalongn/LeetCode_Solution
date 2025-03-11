class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        count = {}
        left = right = result = 0

        while right < len(s):
            count[s[right]] = count.get(s[right], 0) + 1
            while len(count) == 3:
                result += len(s) - right
                count[s[left]] -= 1
                if count[s[left]] == 0:
                    del count[s[left]]
                left += 1

            right += 1

        return result
