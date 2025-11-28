from collections import defaultdict
from typing import List


class Solution:
    def maxKDivisibleComponents(
        self, n: int, edges: List[List[int]], values: List[int], k: int
    ) -> int:
        adj = defaultdict(list)
        src = 0
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        components = 0
        visited = set()

        def dfs(root):
            nonlocal components
            if root in visited:
                return 0
            visited.add(root)
            cur_sum = values[root]
            for neigh in adj[root]:
                cur_sum += dfs(neigh)
            if cur_sum % k == 0:
                components += 1
                return 0
            return cur_sum % k

        dfs(src)
        return components
