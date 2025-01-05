class MyStack:

    def __init__(self):
        self.queue = []

    def push(self, x: int) -> None:
        newqueue = []
        newqueue.append(x)
        while self.queue:
            newqueue.append(self.queue.pop(0))
        self.queue = newqueue

    def pop(self) -> int:
        return self.queue.pop(0)

    def top(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        return False if self.queue else True
