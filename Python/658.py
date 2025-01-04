from typing import List


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left, right = 0, len(arr) - k
        while left < right:
            m = (left + right) // 2
            if x - arr[m] > arr[m + k] - x:
                left = m + 1
            else:
                right = m
        return arr[left : left + k]
