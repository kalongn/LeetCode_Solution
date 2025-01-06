class Solution:

    # @return -1 if num is higher than the picked number
    #          1 if num is lower than the picked number
    #          otherwise return 0
    # def guess(num: int) -> int:  

    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            mid = left + (right - left) // 2
            return_val = guess(mid)
            if return_val == 0:
                return mid
            elif return_val == 1:
                left = mid + 1
            else:
                right = mid - 1
        return -1
