class Solution {
    public int getWinner(int[] arr, int k) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int current = arr[0], wins = 0;
        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];
            if (current > opponent) {
                wins++;
            } else {
                current = opponent;
                wins = 1;
            }
            if (wins == k || current == max) {
                return current;
            }
        }
        return -1;
    }
}
