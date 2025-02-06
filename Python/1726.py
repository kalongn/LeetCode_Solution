from typing import List


class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:
        product_map = dict()

        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                product = nums[i] * nums[j]
                product_map[product] = product_map.get(product, 0) + 1

        result = 0
        for val in product_map.values():
            result += val * (val - 1) // 2 * 8
        return result
