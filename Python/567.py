class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        window_size = len(s1)
        s1_map = [0] * 26
        s2_map = [0] * 26
        for i in range(window_size):
            s1_map[ord(s1[i]) - ord("a")] += 1
            s2_map[ord(s2[i]) - ord("a")] += 1

        matches = 0
        for i in range(26):
            if s1_map[i] == s2_map[i]:
                matches += 1

        for i in range(window_size, len(s2)):
            if matches == 26:
                return True

            index = ord(s2[i]) - ord("a")
            s2_map[index] += 1

            if s2_map[index] == s1_map[index]:
                matches += 1
            elif s2_map[index] - 1 == s1_map[index]:
                matches -= 1

            index = ord(s2[i - window_size]) - ord("a")
            s2_map[index] -= 1
            if s2_map[index] == s1_map[index]:
                matches += 1
            elif s2_map[index] + 1 == s1_map[index]:
                matches -= 1

        return matches == 26
