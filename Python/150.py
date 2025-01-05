from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            match token:
                case "+":
                    stack.append(stack.pop() + stack.pop())
                case "-":
                    op1 = stack.pop()
                    op2 = stack.pop()
                    stack.append(op2 - op1)
                case "*":
                    stack.append(stack.pop() * stack.pop())
                case "/":
                    op1 = stack.pop()
                    op2 = stack.pop()
                    stack.append(int(float(op2) / op1))
                case _:
                    stack.append(int(token))
        return stack[0]
