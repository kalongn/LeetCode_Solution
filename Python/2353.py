from collections import defaultdict
from heapq import heappop, heappush
from typing import List


class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.food_to_rating = {}
        self.food_to_cuisine = {}
        self.cuisine_to_heap = defaultdict(list)
        for i in range(len(foods)):
            self.food_to_cuisine[foods[i]] = cuisines[i]
            self.food_to_rating[foods[i]] = -ratings[i]
            heappush(self.cuisine_to_heap[cuisines[i]], (-ratings[i], foods[i]))

    def changeRating(self, food: str, newRating: int) -> None:
        cuisine = self.food_to_cuisine[food]
        heappush(self.cuisine_to_heap[cuisine], (-newRating, food))
        self.food_to_rating[food] = -newRating

    def highestRated(self, cuisine: str) -> str:
        while (
            self.cuisine_to_heap[cuisine]
            and self.cuisine_to_heap[cuisine][0][0]
            != self.food_to_rating[self.cuisine_to_heap[cuisine][0][1]]
        ):
            heappop(self.cuisine_to_heap[cuisine])
        return (
            self.cuisine_to_heap[cuisine][0][1]
            if self.cuisine_to_heap[cuisine]
            else None
        )
