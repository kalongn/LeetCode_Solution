from typing import List


class Bank:

    def __init__(self, balance: List[int]):
        self.length = len(balance)
        self.registry = [-1] + balance

    def _accountIdCheck(self, account):
        return 1 <= account <= self.length

    def transfer(self, account1: int, account2: int, money: int) -> bool:
        if not (self._accountIdCheck(account1) and self._accountIdCheck(account2)):
            return False
        if self.registry[account1] < money:
            return False
        self.registry[account1] -= money
        self.registry[account2] += money
        return True

    def deposit(self, account: int, money: int) -> bool:
        if not self._accountIdCheck(account):
            return False
        self.registry[account] += money
        return True

    def withdraw(self, account: int, money: int) -> bool:
        if not self._accountIdCheck(account):
            return False
        if self.registry[account] < money:
            return False
        self.registry[account] -= money
        return True
