import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            List<Integer> group = map.getOrDefault(size, new ArrayList<>());
            group.add(i);
            map.put(size, group);

            if (group.size() == size) {
                list.add(group);
                map.remove(size);
            }
        }

        return list;
    }
}
