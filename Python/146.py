class Node:

    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = self.nxt = None


class LRUCache:

    def __init__(self, capacity: int):
        self.c = capacity
        self.cache = dict()  # key -> Node(key, val)
        self.left, self.right = Node(-1, -1), Node(-1, -1)
        self.left.nxt, self.right.prev = self.right, self.left

    def remove(self, node):
        prev, nxt = node.prev, node.nxt
        prev.nxt, nxt.prev = nxt, prev

    def append(self, node):
        prev, nxt = self.right.prev, self.right
        prev.nxt = nxt.prev = node
        node.prev, node.nxt = prev, nxt

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self.remove(self.cache[key])
        self.append(self.cache[key])
        return self.cache[key].val

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        self.cache[key] = Node(key, value)
        self.append(self.cache[key])

        if len(self.cache) > self.c:
            del self.cache[self.left.nxt.key]
            self.remove(self.left.nxt)
