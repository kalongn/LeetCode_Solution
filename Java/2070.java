import java.util.*;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int currMaxBeauty = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];

            if (currMaxBeauty >= beauty) {
                continue;
            }

            currMaxBeauty = beauty;
            map.put(price, currMaxBeauty);
        }

        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(queries[i]);
            if (entry != null) {
                result[i] = entry.getValue();
            } else {
                result[i] = 0;
            }
        }
        return result;

    }
}