class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        empty_bottles, full_bottles = 0, numBottles
        drank = 0

        while full_bottles > 0:
            drank += full_bottles
            empty_bottles += full_bottles
            full_bottles = empty_bottles // numExchange
            empty_bottles = empty_bottles % numExchange

        return drank
