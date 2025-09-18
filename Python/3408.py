from heapq import heapify, heappop, heappush
from typing import List


class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        self.task = {
            task_id: (user_id, priority) for user_id, task_id, priority in tasks
        }
        self.heap = [(-priority, -task_id) for _, task_id, priority in tasks]
        heapify(self.heap)

    def add(self, userId: int, taskId: int, priority: int) -> None:
        self.task[taskId] = (userId, priority)
        heappush(self.heap, (-priority, -taskId))

    def edit(self, taskId: int, newPriority: int) -> None:
        self.task[taskId] = (self.task[taskId][0], newPriority)
        heappush(self.heap, (-newPriority, -taskId))

    def rmv(self, taskId: int) -> None:
        del self.task[taskId]

    def execTop(self) -> int:
        while self.heap:
            priority, task_id = heappop(self.heap)
            if -task_id in self.task and self.task[-task_id][1] == -priority:
                user = self.task[-task_id][0]
                del self.task[-task_id]
                return user
        return -1


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()
