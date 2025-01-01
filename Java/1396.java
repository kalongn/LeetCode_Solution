import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, Pair<String, Integer>> checkinMaps;
    private Map<String, Pair<Double, Integer>> actualMaps;

    public UndergroundSystem() {
        checkinMaps = new HashMap<>();
        actualMaps = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkinMaps.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkOutPair = checkinMaps.remove(id);
        String routeName = checkOutPair.getItem1() + "-" + stationName;
        int timeUsed = t - checkOutPair.getItem2();
        Pair<Double, Integer> inActualMapPair = actualMaps.getOrDefault(routeName, new Pair<>(0.0, 0));
        actualMaps.put(routeName, new Pair<>(timeUsed + inActualMapPair.getItem1(), inActualMapPair.getItem2() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        Pair<Double, Integer> routePair = actualMaps.get(route);
        return routePair.getItem1() / routePair.getItem2();
    }
}

class Pair<T, K> {

    private T item1;
    private K item2;

    public Pair(T item1, K item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public K getItem2() {
        return item2;
    }

    public boolean equals(Pair<T, K> otherPair) {
        if (!this.item1.equals(otherPair.item1)) {
            return false;
        }
        if (!this.item2.equals(otherPair.item2)) {
            return false;
        }
        return true;
    }
}
