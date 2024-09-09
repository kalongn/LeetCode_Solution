import java.util.*;

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i = 0, j = 0;
        int current_direction = 0;
        int[][] directions = {
                { 0, 1 },
                { 1, 0 },
                { 0, -1 },
                { -1, 0 },
        };

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }

        while (head != null) {
            result[i][j] = head.val;
            int nextI = i + directions[current_direction][0];
            int nextY = j + directions[current_direction][1];
            if (nextI < 0 || nextY < 0 || nextI >= m || nextY >= n || result[nextI][nextY] != -1) {
                current_direction = (current_direction + 1) % 4;
            }

            i += directions[current_direction][0];
            j += directions[current_direction][1];

            head = head.next;
        }

        return result;
    }
}
