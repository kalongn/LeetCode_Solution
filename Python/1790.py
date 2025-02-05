class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        num_diff = 0
        first, second = -1, -1
        for i, (c1, c2) in enumerate(zip(s1, s2)):
            if c1 != c2:
                num_diff += 1
                if num_diff > 2:
                    return False
                elif num_diff == 1:
                    first = i
                else:
                    second = i

        if num_diff == 0:
            return True
        if num_diff == 1:
            return False

        return s1[first] == s2[second] and s1[second] == s2[first]
