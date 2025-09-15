class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        result = 0
        words = text.split(" ")
        broken = set(list(brokenLetters))
        for word in words:
            for c in word:
                if c in broken:
                    result += 1
                    break
        return len(words) - result
