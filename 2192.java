import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> parentToKids = new HashMap<>();
        for (int[] e : edges) {
            parentToKids.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
            ++inDegree[e[1]];
        }

        List<Set<Integer>> sets = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            sets.add(new HashSet<>());
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int kid : parentToKids.getOrDefault(parent, Arrays.asList())) {
                sets.get(kid).add(parent);
                sets.get(kid).addAll(sets.get(parent));
                if (--inDegree[kid] == 0) {
                    q.offer(kid);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Set<Integer> set : sets) {
            ans.add(new ArrayList<>(new TreeSet<>(set)));
        }
        return ans;
    }
}