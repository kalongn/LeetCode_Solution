class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int result = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }
        minutes = minutes > grumpy.length ? grumpy.length : minutes;
        int grumpySum = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                grumpySum += customers[i];
            }
        }
        int left = 0;
        int right = minutes;
        int grumpyMax = grumpySum;
        while (right < grumpy.length) {
            if (grumpy[left] == 1) {
                grumpySum -= customers[left];
            }
            if (grumpy[right] == 1) {
                grumpySum += customers[right];
            }
            grumpyMax = Math.max(grumpyMax, grumpySum);
            left++;
            right++;
        }
        result += grumpyMax;
        return result;
    }
}
