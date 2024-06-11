import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];

        for (int i : arr1) {
            bucket[i]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i : arr2) {
            while (bucket[i] > 0) {
                result.add(i);
                bucket[i]--;
            }
        }
        for (int i = 0; i <= 1000; i++) {
            while (bucket[i] > 0) {
                result.add(i);
                bucket[i]--;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}