from typing import List


class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        monod = []
        for pos, sp in sorted(list(zip(position, speed)), reverse=True):
            time = (target - pos) / sp
            if not monod or time > monod[-1]:
                monod.append(time)
        return len(monod)
