import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int currentNumber = 1;

        for (int i = 0; i < n; ++i) {
            result.add(currentNumber);
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10;
                }
                currentNumber += 1;
            }
        }

        return result;
    }
}
