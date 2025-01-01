import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] carArray = new Car[n];
        for (int i = 0; i < n; i++) {
            carArray[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(carArray, (x, y) -> Integer.compare(target - x.position, target - y.position));
        Deque<Double> monoStack = new ArrayDeque<>();

        for (Car i : carArray) {
            if (monoStack.isEmpty()) {
                monoStack.push((double) (target - i.position) / i.speed);
                continue;
            }
            double time = (double) (target - i.position) / i.speed;
            if (time > monoStack.peek()) {
                monoStack.push(time);
            }
        }
        return monoStack.size();
    }
}

class Car {
    int position, speed;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}
