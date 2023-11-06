import java.util.*;

class SeatManager {

    PriorityQueue<Integer> heap;
    int count = 0;

    public SeatManager(int n) {
        count = 1;
        heap = new PriorityQueue<>();
    }

    public int reserve() {
        if (heap.size() == 0) {
            return count++;
        }
        return heap.poll();
    }

    public void unreserve(int seatNumber) {
        heap.add(seatNumber);
    }
}
