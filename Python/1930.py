class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        left_most = [-1] * 26
        right_most = [-1] * 26

        for i, c in enumerate(s):
            c_index = ord(c) - ord("a")
            if left_most[c_index] == -1:
                left_most[c_index] = i
            right_most[c_index] = i

        result = 0
        for c_index in range(26):
            if left_most[c_index] == -1 or left_most[c_index] == right_most[c_index]:
                continue

            result += len(set(s[left_most[c_index] + 1 : right_most[c_index]]))

        return result
