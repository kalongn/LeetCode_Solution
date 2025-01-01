import java.util.*;

class MyCalendarTwo {
    private List<int[]> events;
    private List<int[]> doubleBookings;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] db : doubleBookings) {
            if (start < db[1] && end > db[0]) {
                return false;
            }
        }

        for (int[] event : events) {
            if (start < event[1] && end > event[0]) {
                doubleBookings.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1]) });
            }
        }

        events.add(new int[] { start, end });
        return true;
    }
}