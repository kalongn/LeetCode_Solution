import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (map.size() > 0) {
            int temp = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                if (!map.containsKey(temp + i)) {
                    return false;
                }
                map.put(temp + i, map.get(temp + i) - 1);
                if (map.get(temp + i) == 0) {
                    map.remove(temp + i);
                }
            }
        }
        return true;
    }
}
