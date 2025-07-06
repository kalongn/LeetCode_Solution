from typing import Counter, List


class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.nums1 = nums1
        self.nums2 = nums2
        self.freq = Counter(nums2)

    def add(self, index: int, val: int) -> None:
        _nums2, _freq = self.nums2, self.freq

        _freq[_nums2[index]] -= 1
        _nums2[index] += val
        _freq[_nums2[index]] += 1

    def count(self, tot: int) -> int:
        _nums1, _freq = self.nums1, self.freq

        result = 0
        for num in _nums1:
            if (rest := tot - num) in _freq:
                result += _freq[rest]
        return result
