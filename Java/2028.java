import java.util.*;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int actualSum = mean * (rolls.length + n);
        int remainSum = actualSum;
        for (int i : rolls) {
            remainSum -= i;
        }
        if (6 * n < remainSum || remainSum < n) {
            return new int[0];
        }
        int distributed = remainSum / n;
        int mod = remainSum % n;
        int[] otherRolls = new int[n];
        Arrays.fill(otherRolls, distributed);
        for (int i = 0; i < mod; i++) {
            otherRolls[i]++;
        }
        return otherRolls;
    }
}
