from typing import List


class Solution:
    def checkIfPrerequisite(
        self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]
    ) -> List[bool]:
        isPrerequisite = [[False] * numCourses for _ in range(numCourses)]

        for edge in prerequisites:
            isPrerequisite[edge[0]][edge[1]] = True

        for mid in range(numCourses):
            for src in range(numCourses):
                for target in range(numCourses):
                    isPrerequisite[src][target] = isPrerequisite[src][target] or (
                        isPrerequisite[src][mid] and isPrerequisite[mid][target]
                    )

        answer = []
        for query in queries:
            answer.append(isPrerequisite[query[0]][query[1]])

        return answer
