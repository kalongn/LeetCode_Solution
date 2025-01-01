import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, temp);
        return result;
    }

    private void backtrack(int[] candidates, int index, int target, List<Integer> current) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}