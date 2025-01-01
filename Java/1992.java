import java.util.*;

class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int x = i, y = j;
                    for (x = i; x < land.length && land[x][j] == 1; x++) {
                        for (y = j; y < land[0].length && land[x][y] == 1; y++) {
                            land[x][y] = 0;
                        }
                    }
                    int[] arr = new int[] { i, j, x - 1, y - 1 };
                    result.add(arr);
                }
            }
        }
        return result.stream().toArray(int[][]::new);
    }
}
