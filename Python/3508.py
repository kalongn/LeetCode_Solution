from bisect import bisect_left, bisect_right
from collections import defaultdict, deque
from typing import List


class Router:

    def __init__(self, memoryLimit: int):
        self.packet_set = set()
        self.destination_to_timestamp = defaultdict(deque)
        self.queue = deque(maxlen=memoryLimit)

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        new_packet = (source, destination, timestamp)
        if new_packet in self.packet_set:
            return False
        if len(self.queue) == self.queue.maxlen:
            self.forwardPacket()
        self.queue.append(new_packet)
        self.packet_set.add(new_packet)
        self.destination_to_timestamp[destination].append(timestamp)
        return True

    def forwardPacket(self) -> List[int]:
        if not self.queue:
            return []
        forward_packet = self.queue.popleft()
        self.packet_set.remove(forward_packet)
        self.destination_to_timestamp[forward_packet[1]].popleft()
        return forward_packet

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        return bisect_right(
            self.destination_to_timestamp[destination], endTime
        ) - bisect_left(self.destination_to_timestamp[destination], startTime)


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)
