class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > max) {
                max = freq[num];
            }
        }
        int result = 0;
        for (int i : freq) {
            if (i == max) {
                result += max;
            }
        }
        return result;
    }
}
