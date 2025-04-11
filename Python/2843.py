class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        count = 0

        def sum_digit(num_str):
            result = 0
            for i in range(len(num_str)):
                result += int(num_str[i])

            return result

        for num in range(low, high + 1):
            num_str = str(num)
            n = len(num_str)
            if n % 2 != 0:
                continue
            first_half, second_half = num_str[: n // 2], num_str[n // 2 :]
            if sum_digit(first_half) == sum_digit(second_half):
                count += 1

        return count
