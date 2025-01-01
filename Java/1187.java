import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<>(arr2.length);
        for (int i = 0, p = -1; i < arr2.length; i++) {
            if (arr2[i] != p) {
                p = arr2[i];
                list.add(p);
            }
        }
        int n = arr1.length, m = list.size(), N = Integer.MAX_VALUE >> 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = i < n ? arr1[i] : N;
            int idx = binarySearch(list, num);
            int cnt = idx >= i ? i : N;
            if (arr1[i - 1] < num) {
                cnt = Math.min(cnt, dp[i - 1]);
            }
            for (int j = i - 2, k = idx - 1; j >= 0 && k >= 0; j--, k--) {
                if (arr1[j] < list.get(k)) {
                    cnt = Math.min(cnt, dp[j] + idx - k);
                }
            }
            dp[i] = cnt;
        }
        return dp[n] == N ? -1 : dp[n];
    }

    private int binarySearch(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}