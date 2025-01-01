import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int base = 0, delta = 0;
        int n = base;
        while (n <= high) {
            if (n >= low) {
                result.add(n);
            }
            n += delta;
            if (n % 10 == 0) {
                base = base * 10 + (base % 10 + 1);
                delta = delta * 10 + 1;
                n = base;
            }
        }

        return result;
    }
}
