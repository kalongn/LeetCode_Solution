class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""

        count, window = {}, {}
        for c in t:
            count[c] = 1 + count.get(c, 0)

        have, need = 0, len(count)
        res, res_len = [-1, -1], float("infinity")
        left = 0
        for right in range(len(s)):
            c = s[right]
            window[c] = 1 + window.get(c, 0)

            if c in count and window[c] == count[c]:
                have += 1

            while have == need:
                if (right - left + 1) < res_len:
                    res, res_len = [left, right], (right - left + 1)
                window[s[left]] -= 1
                if s[left] in count and window[s[left]] < count[s[left]]:
                    have -= 1
                left += 1
        return s[res[0] : res[1] + 1] if res_len != float("infinity") else ""
