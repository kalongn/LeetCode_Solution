class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        indices = dict()
        for i in range(len(s)):
            c = s[i]
            if c not in indices:
                indices[c] = (i, i)
            else:
                first = indices[c][0]
                indices[c] = (first, i)

        result = 0
        for value in indices.values():
            if value[0] == value[1]:
                continue
            result += len(set(s[value[0] + 1 : value[1]]))

        return result
