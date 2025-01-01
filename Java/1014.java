class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0, max = values[0] - 1;
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, values[i] + max);
            max = Math.max(max - 1, values[i] - 1);
        }
        return result;
    }
}
