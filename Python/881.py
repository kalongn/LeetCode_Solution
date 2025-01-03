from typing import List


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        left, right = 0, len(people) - 1
        result = 0
        while people[right] == limit:
            result += 1
            right -= 1

        while left <= right:
            if limit - people[right] >= people[left]:
                left += 1
            right -= 1
            result += 1

        return result
