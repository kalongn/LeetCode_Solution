class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        w1, w2 = 0, 0
        result = ""
        while w1 < len(word1) or w2 < len(word2):
            if w1 < len(word1) and w2 < len(word2):
                result += word1[w1] + word2[w2]
                w1 += 1
                w2 += 1
            elif w1 < len(word1):
                result += word1[w1]
                w1 += 1
            else:
                result += word2[w2]
                w2 += 1

        return result
