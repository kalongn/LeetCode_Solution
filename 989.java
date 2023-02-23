import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int length = num.length - 1;
        while (length >= 0 || k != 0) {
            if (length >= 0) {
                k += num[length--];
            }
            result.addFirst(k % 10);
            k /= 10;
        }
        return result;
    }
}