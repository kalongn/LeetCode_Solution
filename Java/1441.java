import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int currentNum = 1;
        for (int i = 0; i < target.length; i++) {
            while (currentNum != target[i]) {
                result.add("Push");
                result.add("Pop");
                currentNum++;
            }
            result.add("Push");
            currentNum++;
        }
        return result;
    }
}
