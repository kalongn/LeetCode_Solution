import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return result;
    }
}