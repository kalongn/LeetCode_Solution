from collections import deque
from typing import List


class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)
        reverse_graph = [[] for _ in range(n)]
        indegree = [0] * n
        q = deque()

        for i in range(n):
            for edge in graph[i]:
                reverse_graph[edge].append(i)
                indegree[i] += 1

            if indegree[i] == 0:
                q.append(i)

        safe = [False] * n
        while q:
            node = q.popleft()
            safe[node] = True

            for neighbor in reverse_graph[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    q.append(neighbor)

        result = [i for i in range(n) if safe[i]]
        return result
