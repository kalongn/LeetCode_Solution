class Node:
    def __init__(self, key = -1, val = -1, next = None):
        self.key = key
        self.val = val
        self.next = next

class MyHashMap:

    def __init__(self):
        self.map = [Node() for _ in range(1000)]

    def hash(self, key):
        return key % len(self.map)

    def put(self, key: int, value: int) -> None:
        dummy = self.map[self.hash(key)]
        while dummy.next:
            if dummy.next.key == key:
                dummy.next.val = value
                return
            dummy = dummy.next
        dummy.next = Node(key, value)

    def get(self, key: int) -> int:
        dummy = self.map[self.hash(key)].next
        while dummy:
            if dummy.key == key:
                return dummy.val
            dummy = dummy.next
        return -1

    def remove(self, key: int) -> None:
        dummy = self.map[self.hash(key)]
        while dummy.next:
            if dummy.next.key == key:
                dummy.next = dummy.next.next
                return
            dummy = dummy.next