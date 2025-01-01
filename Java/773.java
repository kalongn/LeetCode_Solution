import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";

        StringBuilder start_ = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++)
                start_.append(board[i][j]);
        }
        String start = start_.toString();

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        int[][] swap = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

        int level = 0;

        visited.add(start);
        q.offer(start);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String temp = q.poll();
                if (temp.equals(target)) {
                    return level;
                }

                int index = temp.indexOf('0');
                for (int swapIndex : swap[index]) {
                    StringBuilder sb = new StringBuilder(temp);

                    sb.setCharAt(index, temp.charAt(swapIndex));
                    sb.setCharAt(swapIndex, '0');

                    String puzz = sb.toString();

                    if (visited.contains(puzz) == true) {
                        continue;
                    }

                    visited.add(puzz);
                    q.offer(puzz);
                }
            }
            level += 1;
        }
        return -1;
    }
}