from typing import Counter, List


class Solution:
    def minimumTeachings(
        self, n: int, languages: List[List[int]], friendships: List[List[int]]
    ) -> int:
        languages = [set(l) for l in languages]

        dont_speak = set()
        for u, v in friendships:
            u = u - 1
            v = v - 1
            if languages[u] & languages[v]:
                continue

            dont_speak.add(u)
            dont_speak.add(v)

        language_count = Counter()

        for can_teach_language in dont_speak:
            for l in languages[can_teach_language]:
                language_count[l] += 1

        return (
            0
            if not dont_speak
            else len(dont_speak) - max(list(language_count.values()))
        )
