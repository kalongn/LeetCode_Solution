import java.util.*;

class Solution {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (y.count - x.count));
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int count = p.count;
            char character = p.character;
            if (ans.length() >= 2 &&
                    ans.charAt(ans.length() - 1) == p.character &&
                    ans.charAt(ans.length() - 2) == p.character) {
                if (pq.isEmpty()) {
                    break;
                }

                Pair temp = pq.poll();
                ans.append(temp.character);
                if (temp.count - 1 > 0) {
                    pq.add(new Pair(temp.count - 1, temp.character));
                }
            } else {
                count--;
                ans.append(character);
            }

            if (count > 0) {
                pq.add(new Pair(count, character));
            }
        }
        return ans.toString();
    }

    class Pair {

        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }
}
