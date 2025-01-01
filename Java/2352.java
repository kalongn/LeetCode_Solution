import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        Map<String, Integer> rows = new HashMap<>();
        for (int[] i : grid) {
            String intArrayString = Arrays.toString(i);
            rows.put(intArrayString, rows.getOrDefault(intArrayString, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid[i].length];
            for (int j = 0; j < col.length; j++) {
                col[j] = grid[j][i];
            }
            result += rows.getOrDefault(Arrays.toString(col), 0);
        }
        return result;
    }
}
