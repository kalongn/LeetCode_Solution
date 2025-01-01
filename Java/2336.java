import java.util.HashSet;
import java.util.PriorityQueue;

class SmallestInfiniteSet {

    private HashSet<Integer> isPresent;
    private PriorityQueue<Integer> addedIntegers;
    private int currentInt;

    public SmallestInfiniteSet() {
        isPresent = new HashSet<>();
        addedIntegers = new PriorityQueue<>();
        currentInt = 1;
    }

    public int popSmallest() {
        int answer;
        if (!addedIntegers.isEmpty()) {
            answer = addedIntegers.poll();
            isPresent.remove(answer);
        } else {
            answer = currentInt;
            currentInt++;
        }
        return answer;
    }

    public void addBack(int num) {
        if (currentInt <= num || isPresent.contains(num)) {
            return;
        }
        addedIntegers.add(num);
        isPresent.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
