class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int leftSmaller = 0, rightLarger = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rating[j] < rating[i]) {
                    leftSmaller++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) {
                    rightLarger++;
                }
            }

            int leftLarger = i - leftSmaller;
            int rightSmaller = n - i - 1 - rightLarger;

            result += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }

        return result;
    }
}