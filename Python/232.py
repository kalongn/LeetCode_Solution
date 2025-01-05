class MyQueue:

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        temp_stack = []
        while self.stack:
            temp_stack.append(self.stack.pop())
        val = None
        if temp_stack:
            val = temp_stack.pop()
        while temp_stack:
            self.stack.append(temp_stack.pop())
        return val

    def peek(self) -> int:
        temp_stack = []
        while self.stack:
            temp_stack.append(self.stack.pop())
        val = None
        if temp_stack:
            val = temp_stack[-1]
        while temp_stack:
            self.stack.append(temp_stack.pop())
        return val

    def empty(self) -> bool:
        return False if self.stack else True
