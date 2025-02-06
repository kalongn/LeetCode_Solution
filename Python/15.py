from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        triplets = []
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            firstNum = nums[i]
            j, k = i + 1, len(nums) - 1
            while j < k:
                secondNum, thirdNum = nums[j], nums[k]
                potentialSum = firstNum + secondNum + thirdNum
                if potentialSum > 0:
                    k -= 1
                elif potentialSum < 0:
                    j += 1
                else:
                    triplets.append([firstNum, secondNum, thirdNum])
                    j, k = j + 1, k - 1
                    while j < k and nums[j] == nums[j - 1]:
                        j += 1
                    while j < k and nums[k] == nums[k + 1]:
                        k -= 1
        return triplets
