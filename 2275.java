class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[24];
        for (int i = 0; i < 24; i++) {
            for (int num : candidates) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        int result = 0;
        for (int count : bitCount) {
            if (count > result) {
                result = count;
            }
        }
        return result;
    }
}
