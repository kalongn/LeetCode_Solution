import re
from typing import List


class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        words = set(wordlist)
        cap = {}
        vowel = {}

        for word in wordlist:
            lower = word.lower()
            devowel = re.sub("[aeiou]", "#", lower)
            if lower not in cap:
                cap[lower] = word
            if devowel not in vowel:
                vowel[devowel] = word

        result = [""] * len(queries)
        for i, query in enumerate(queries):
            if query in words:
                result[i] = query
                continue

            lower = query.lower()
            devowel = re.sub("[aeiou]", "#", lower)

            if lower in cap:
                result[i] = cap[lower]
            elif devowel in vowel:
                result[i] = vowel[devowel]

        return result
