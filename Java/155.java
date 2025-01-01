import java.util.*;

class MinStack {

    Deque<Integer> itemStack, minStack;

    public MinStack() {
        itemStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        itemStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        itemStack.pop();
        minStack.pop();
    }

    public int top() {
        return itemStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
