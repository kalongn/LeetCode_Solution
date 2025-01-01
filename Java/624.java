import java.util.*;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxNumber = -10001, minNumber = 10001;
        int result = 0;
        for (List<Integer> i : arrays) {
            int min = i.get(0);
            int max = i.get(i.size() - 1);
            result = Math.max(result, Math.max(max - minNumber, maxNumber - min));
            maxNumber = Math.max(maxNumber, max);
            minNumber = Math.min(minNumber, min);
        }
        return result;
    }
}
