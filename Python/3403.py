class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        if numFriends == 1:
            return word
        n = len(word)
        result = ""
        for i in range(n):
            result = max(result, word[i : min(i + n - numFriends + 1, n)])
        return result
