import java.util.*;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if ((i % 2 == 0 && seen.contains(i / 2)) || seen.contains(i * 2)) {
                return true;
            }
            seen.add(i);
        }
        return false;
    }
}