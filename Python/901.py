class StockSpanner:

    def __init__(self):
        self.stock_price = []  # (prices, span)

    def next(self, price: int) -> int:
        result = 1
        while self.stock_price and self.stock_price[-1][0] <= price:
            result += self.stock_price.pop()[1]

        self.stock_price.append((price, result))
        return result
