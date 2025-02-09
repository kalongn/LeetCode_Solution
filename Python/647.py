class Solution:
    def countSubstrings(self, s: str) -> int:
        def palindrome(left, right):
            count = 0
            while 0 <= left and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
                count += 1

            return count

        count = 0
        for i in range(len(s)):
            odd = palindrome(i - 1, i + 1)
            even = palindrome(i, i + 1)
            count += odd + even + 1

        return count
