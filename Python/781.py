from typing import List


class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        bucket = {}
        result = 0
        for answer in answers:
            if answer == 0:
                result += 1
                continue

            if answer not in bucket or answer == bucket[answer]:
                bucket[answer] = 0
                result += 1 + answer
            else:
                bucket[answer] += 1

        return result
