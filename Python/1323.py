class Solution:
    def maximum69Number(self, num: int) -> int:
        index = 0
        str_num = list(str(num))

        while index < len(str_num):
            if str_num[index] == "6":
                str_num[index] = "9"
                break
            index += 1

        return int("".join(str_num))
