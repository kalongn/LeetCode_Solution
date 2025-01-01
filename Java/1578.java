class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int result = 0;
        int prevCost = neededTime[0];

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                result += Math.min(neededTime[i], prevCost);
                prevCost = Math.max(neededTime[i], prevCost);
            } else
                prevCost = neededTime[i];
        }

        return result;
    }
}
