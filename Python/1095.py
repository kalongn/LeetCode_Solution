# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
# class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:


class Solution:
    def findInMountainArray(self, target: int, mountainArr: "MountainArray") -> int:
        length = mountainArr.length()

        # Find Peak
        l, r = 1, length - 2
        while l <= r:
            m = l + (r - l) // 2
            left, mid, right = (
                mountainArr.get(m - 1),
                mountainArr.get(m),
                mountainArr.get(m + 1),
            )
            if left < mid < right:
                l = m + 1
            elif left > mid > right:
                r = m - 1
            else:
                break
        peak = m

        # Search left portion
        l, r = 0, peak - 1
        while l <= r:
            m = l + (r - l) // 2
            val = mountainArr.get(m)
            if val < target:
                l = m + 1
            elif val > target:
                r = m - 1
            else:
                return m

        # Search right portion
        l, r = peak, length - 1
        while l <= r:
            m = l + (r - l) // 2
            val = mountainArr.get(m)
            if val > target:
                l = m + 1
            elif val < target:
                r = m - 1
            else:
                return m

        return -1
