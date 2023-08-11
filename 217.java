import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> history = new HashSet<>();
        for (int i : nums) {
            if (!history.add(i)) {
                return true;
            }
        }
        return false;
    }
}
