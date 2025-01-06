class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        result = 0
        while left <= right:
            mid = left + (right - left) // 2
            squared = mid * mid
            if squared > x:
                right = mid - 1
            elif squared < x:
                left = mid + 1
                result = mid
            else:
                return mid
        return result
