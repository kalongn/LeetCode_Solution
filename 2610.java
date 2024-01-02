import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];
        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            if (freq[num] >= result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(freq[num]).add(num);
            freq[num]++;
        }
        return result;
    }
}
