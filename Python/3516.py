class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        x_distance, y_distance = abs(x - z), abs(y - z)
        if x_distance == y_distance:
            return 0
        elif x_distance > y_distance:
            return 2
        else:
            return 1
