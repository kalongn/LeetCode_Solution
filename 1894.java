class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sumOfK = 0;
        for (int i : chalk) {
            sumOfK += i;
            if (sumOfK > k) {
                break;
            }
        }
        k %= sumOfK;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}
