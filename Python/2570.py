from typing import List


class Solution:
    def mergeArrays(
        self, nums1: List[List[int]], nums2: List[List[int]]
    ) -> List[List[int]]:
        result = []

        left, right = 0, 0
        while left < len(nums1) and right < len(nums2):
            if nums1[left][0] == nums2[right][0]:
                result.append([nums1[left][0], nums1[left][1] + nums2[right][1]])
                left += 1
                right += 1
            elif nums1[left][0] < nums2[right][0]:
                result.append([nums1[left][0], nums1[left][1]])
                left += 1
            else:
                result.append([nums2[right][0], nums2[right][1]])
                right += 1

        if left < len(nums1):
            result += nums1[left:]
        elif right < len(nums2):
            result += nums2[right:]

        return result
