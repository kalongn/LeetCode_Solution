import java.util.*;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : target) {
            if (map.get(i) == null) {
                return false;
            } else if (map.get(i) == 1) {
                map.remove(i);
            } else {
                map.put(i, map.get(i) - 1);
            }
        }
        return map.isEmpty();
    }
}
