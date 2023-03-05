import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/jump-game-iv/solutions/1690813/best-explanation-ever-possible-for-this-question/?orderBy=most_votes&languageTags=java

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int step = 0;

        // fill the map
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int j = q.poll();

                if (j - 1 >= 0 && map.containsKey(arr[j - 1])) {
                    q.offer(j - 1);
                }

                if (j + 1 < n && map.containsKey(arr[j + 1])) {
                    if (j + 1 == n - 1)
                        return step;
                    q.offer(j + 1);
                }

                if (map.containsKey(arr[j])) {
                    for (int k : map.get(arr[j])) {
                        if (k != j) {
                            if (k == n - 1)
                                return step;
                            q.offer(k);
                        }
                    }
                }
                map.remove(arr[j]);
            }
        }

        return step;
    }
}