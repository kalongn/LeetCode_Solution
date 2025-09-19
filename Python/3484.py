class Spreadsheet:

    def __init__(self, rows: int):
        self.cells = {}

    def setCell(self, cell: str, value: int) -> None:
        self.cells[cell] = value

    def resetCell(self, cell: str) -> None:
        if cell in self.cells:
            del self.cells[cell]

    def getValue(self, formula: str) -> int:
        left, right = formula.split("+")
        left = left[1:]

        if left[0].isalpha():
            left_val = self.cells.get(left, 0)
        else:
            left_val = int(left)

        if right[0].isalpha():
            right_val = self.cells.get(right, 0)
        else:
            right_val = int(right)

        return left_val + right_val


# Your Spreadsheet object will be instantiated and called as such:
# obj = Spreadsheet(rows)
# obj.setCell(cell,value)
# obj.resetCell(cell)
# param_3 = obj.getValue(formula)
