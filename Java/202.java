import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> history = new HashSet<>();
        while (n != 1 && !history.contains(n)) {
            history.add(n);

            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
