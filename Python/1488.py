from collections import defaultdict, deque
from heapq import heappop, heappush
from typing import List


class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        nearest_flood_lake = []
        lake_to_rain_day = defaultdict(deque)
        result = [-1] * len(rains)

        for i, lake in enumerate(rains):
            lake_to_rain_day[lake].append(i)

        for i, lake in enumerate(rains):
            if nearest_flood_lake and nearest_flood_lake[0] == i:
                return []

            if lake != 0:
                lake_to_rain_day[lake].popleft()

                if lake_to_rain_day[lake]:
                    next_rain_day = lake_to_rain_day[lake][0]
                    heappush(nearest_flood_lake, next_rain_day)
            else:
                if not nearest_flood_lake:
                    result[i] = 1
                else:
                    nearest_lake_index = heappop(nearest_flood_lake)
                    drain_lake = rains[nearest_lake_index]
                    result[i] = drain_lake

        return result
