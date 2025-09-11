class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = []
        for c in s:
            if c.lower() in "aeiou":
                vowels.append(c)

        if not vowels:
            return s

        vowels.sort()
        result = list(s)
        vowels_index = 0
        for i, c in enumerate(result):
            if c.lower() in "aeiou":
                result[i] = vowels[vowels_index]
                vowels_index += 1

        return "".join(result)
