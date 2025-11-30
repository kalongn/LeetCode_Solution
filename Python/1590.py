from typing import List


class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        n = len(nums)
        target = sum(nums) % p
        if target == 0:
            return 0

        mod_dict = {0: -1}
        curr_sum = 0
        min_len = n

        for i in range(n):
            curr_sum = (curr_sum + nums[i]) % p

            needed = (curr_sum - target + p) % p

            if needed in mod_dict:
                min_len = min(min_len, i - mod_dict[needed])

            mod_dict[curr_sum] = i

        return -1 if min_len == n else min_len
