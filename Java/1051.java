class Solution {
    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int i : heights) {
            bucket[i]++;
        }
        int result = 0, index = 0;
        for (int i = 1; i <= 100; i++) {
            while (bucket[i]-- > 0) {
                if (i != heights[index++]) {
                    result++;
                }
            }
        }
        return result;
    }
}
