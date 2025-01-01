class Solution {
    public int findKthPositive(int[] arr, int k) {
        int init = 1;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != init) {
                k--;
                if (k == 0) {
                    return init;
                }
                init++;
            }
            init++;
        }
        while (k != 1) {
            k--;
            init++;
        }
        return init;
    }
}