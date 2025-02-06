from typing import List


class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        def merge(l, m, r):
            left, right = nums[l : m + 1], nums[m + 1 : r + 1]
            i, j, k = l, 0, 0
            while j < len(left) or k < len(right):
                if j < len(left) and k < len(right):
                    if left[j] <= right[k]:
                        nums[i] = left[j]
                        j += 1
                    else:
                        nums[i] = right[k]
                        k += 1
                elif j < len(left):
                    nums[i] = left[j]
                    j += 1
                else:
                    nums[i] = right[k]
                    k += 1
                i += 1

        def merge_sort(l, r):
            if l == r:
                return

            m = l + (r - l) // 2
            merge_sort(l, m)
            merge_sort(m + 1, r)
            merge(l, m, r)
            return

        merge_sort(0, len(nums))
        return nums
