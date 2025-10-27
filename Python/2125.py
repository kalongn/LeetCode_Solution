from typing import List


class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        result = prev_lasers = 0

        for row in bank:
            laser_count = 0
            for c in row:
                if c == "1":
                    laser_count += 1
            if laser_count == 0:
                continue
            result += prev_lasers * laser_count
            prev_lasers = laser_count

        return result
