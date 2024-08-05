import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (String i : arr) {
            if (map.get(i) == 1) {
                k--;
            }

            if (k == 0) {
                return i;
            }
        }

        return "";
    }
}
