import math


class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n == 1:
            return True

        if n <= 0:
            return False

        logarithm_base4 = math.log(n) / math.log(4)

        return logarithm_base4 == int(logarithm_base4)
