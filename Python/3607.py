from collections import defaultdict
from heapq import heappop, heappush
from typing import List


class DisjointUnion:
    def __init__(self, n):
        self.parent = list(range(n + 1))

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        parent_x, parent_y = self.find(x), self.find(y)
        if parent_x == parent_y:
            return False
        self.parent[parent_y] = parent_x
        return True


class Solution:
    def processQueries(
        self, c: int, connections: List[List[int]], queries: List[List[int]]
    ) -> List[int]:
        disjoint_union = DisjointUnion(c)
        online = [True] * (c + 1)

        for u, v in connections:
            disjoint_union.union(u, v)

        component_heaps = defaultdict(list)
        for station in range(1, c + 1):
            root = disjoint_union.find(station)
            heappush(component_heaps[root], station)

        result = []

        for query_type, x in queries:
            if query_type == 2:
                online[x] = False
            else:
                if online[x]:
                    result.append(x)
                else:
                    root = disjoint_union.find(x)
                    heap = component_heaps[root]
                    while heap and not online[heap[0]]:
                        heappop(heap)
                    result.append(heap[0] if heap else -1)

        return result
