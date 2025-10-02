class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        empty_bottles, full_bottles = 0, numBottles
        drank = 0
        while full_bottles > 0:
            empty_bottles += full_bottles
            drank += full_bottles
            full_bottles = 0
            while empty_bottles >= numExchange:
                empty_bottles -= numExchange
                full_bottles += 1
                numExchange += 1
        return drank