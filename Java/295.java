import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> left, right;
    private boolean isEven;

    public MedianFinder() {
        this.left = new PriorityQueue<>((x, y) -> y - x);
        this.right = new PriorityQueue<>();
        this.isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            this.right.offer(num);
            this.left.offer(this.right.poll());
        } else {
            this.left.offer(num);
            this.right.offer(this.left.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            return (this.left.peek() + this.right.peek()) / 2.0;
        }
        return this.left.peek();
    }
}