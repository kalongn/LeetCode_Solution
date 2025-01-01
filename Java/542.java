import java.util.*;

class Solution {
    /**
     * 
     * 1. apply bfs on zero values and store -1 for other matrix data to denote they
     * are not visited yet.
     *
     * 2. traverse level order wise and for each level update distance only of those
     * indexes who has -1 assigned and currently neighbor of queue.poll.
     * 
     * 3. add such element to back of queue also for next level traversal.
     * 
     * 4. in this way those who are not reachable to any zero in first attempt (i.e.
     * first level), for them new level is checked and hence length counter will
     * increased by 1
     * 
     * 5. now for those new queue element length will be set to updated length if
     * that cell has -1.
     * 
     * @param mat
     * @return updated matrix with distance
     */
    public int[][] updateMatrix(int[][] mat) {
        // Queue to hold the co-ordinates
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    // only those added to queue who has 0 value.
                    queue.add(new int[] { i, j });
                } else {
                    // else set value to -1 to indicate length needed to be updated here.
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int length = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // hold level count
            length++;
            // traverse level order wise
            while (size-- > 0) {
                int[] rc = queue.poll();
                // for each element in queue try all 4 directions
                for (int[] dir : dirs) {
                    int r = rc[0] + dir[0];
                    int c = rc[1] + dir[1];
                    // if out of range or -1 it means no need to process it.
                    if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != -1) {
                        continue;
                    }
                    // if not already -1. update length
                    mat[r][c] = length;
                    // add element to queue for processing
                    queue.add(new int[] { r, c });
                }
            }
        }

        return mat;
    }
}
