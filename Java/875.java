class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for (int i : piles) {
            if (right < i) {
                right = i;
            }
        }
        int left = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentPace = currentPace(mid, piles);
            if (currentPace <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int currentPace(int k, int[] piles) {
        int sum = 0;
        for (int i : piles) {
            sum += Math.ceil((double) i / k);
        }
        return sum;
    }
}