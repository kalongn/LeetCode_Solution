import java.util.*;
import javafx.util.Pair;

class TimeMap {
    private Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> result = this.map.getOrDefault(key, new ArrayList<>());
        result.add(new Pair<String, Integer>(value, timestamp));
        this.map.put(key, result);
    }

    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> search = this.map.getOrDefault(key, new ArrayList<>());
        if (search.isEmpty() || search.get(0).getValue() > timestamp) {
            return "";
        }
        int left = 0, right = search.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search.get(mid).getValue() <= timestamp) {
                result = search.get(mid).getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}