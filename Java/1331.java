import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortArr = new int[arr.length];
        Map<Integer, Integer> itemToRank = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sortArr[i] = arr[i];
        }
        Arrays.sort(sortArr);
        int currentRank = 1;
        for (int i = 0; i < sortArr.length; i++) {
            itemToRank.put(sortArr[i], currentRank);
            while (i < sortArr.length - 1 && sortArr[i] == sortArr[i + 1]) {
                i++;
            }
            currentRank++;
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = itemToRank.get(arr[i]);
        }
        return result;
    }
}
