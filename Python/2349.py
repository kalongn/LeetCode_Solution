import collections


class NumberContainers:

    def __init__(self):
        self.index_num = dict()  # index -> number
        self.num_indices = collections.defaultdict(SortedSet)  # number -> set of index
        # use a heap instead of sorted set is banned

    def change(self, index: int, number: int) -> None:
        if index in self.index_num:
            self.num_indices[self.index_num[index]].remove(index)
            if not self.num_indices[self.index_num[index]]:
                del self.num_indices[self.index_num[index]]

        self.index_num[index] = number
        self.num_indices[number].add(index)

    def find(self, number: int) -> int:
        if number not in self.num_indices or not self.num_indices[number]:
            return -1
        return self.num_indices[number][0]
