class Solution:
    def minMaxDifference(self, num: int) -> int:
        max_str = str(num)
        min_str = max_str
        i = 0
        while i < len(max_str) and max_str[i] == "9":
            i += 1
        if i < len(max_str):
            max_str = max_str.replace(max_str[i], "9")
        min_str = min_str.replace(min_str[0], "0")
        return int(max_str) - int(min_str)
