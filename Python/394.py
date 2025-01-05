class Solution:
    def decodeString(self, s: str) -> str:
        stack, cur_num, cur_str = [], "0", ""
        for c in s:
            if c == "[":
                stack.append(cur_str)
                stack.append(int(cur_num))
                cur_str = ""
                cur_num = "0"
            elif c == "]":
                num = stack.pop()
                prev_str = stack.pop()
                cur_str = prev_str + num * cur_str
            elif c.isdigit():
                cur_num += c
            else:
                cur_str += c

        return cur_str
