import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        String[] splitFirstItem = timePoints.get(0).split(":");
        int firstItemHour = Integer.parseInt(splitFirstItem[0]);
        if (Integer.parseInt(splitFirstItem[0]) < 12) {
            firstItemHour += 24;
            timePoints.add(firstItemHour + ":" + splitFirstItem[1]);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            String first = timePoints.get(i);
            String second = timePoints.get(i + 1);
            String[] splitFirst = first.split(":");
            String[] splitSecond = second.split(":");
            int hourDiff = Integer.parseInt(splitSecond[0]) - Integer.parseInt(splitFirst[0]);
            int minDiff = Integer.parseInt(splitSecond[1]) - Integer.parseInt(splitFirst[1]);
            System.out.println(hourDiff + " " + minDiff);
            result = Math.min(result, hourDiff * 60 + minDiff);
        }

        return result;
    }
}
