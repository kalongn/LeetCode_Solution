import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, Double> map;

    public double knightProbability(int N, int K, int r, int c) {

        map = new HashMap<>();

        // prob returns the total paths which stayed inside the board and then we divide it with total number of moves .

        double result = prob(N, K, r, c) / Math.pow(8, K);
        return result;
    }

    public double prob(int N, int K, int r, int c) {
        // If the path is out of the board return 0 ;
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }
        String key = K + "->" + r + "->" + c;

        // if path is not out of the board and no moves left return 1;
        if (K == 0) {
            return 1;
        }
        if (map.containsKey(key))
            return map.get(key);

        // There are total of 8 possible moves and we are traversing all the possible paths.

        double op1 = prob(N, K - 1, r + 2, c + 1);
        double op2 = prob(N, K - 1, r + 2, c - 1);
        double op3 = prob(N, K - 1, r - 2, c + 1);
        double op4 = prob(N, K - 1, r - 2, c - 1);
        double op5 = prob(N, K - 1, r - 1, c + 2);
        double op6 = prob(N, K - 1, r + 1, c + 2);
        double op7 = prob(N, K - 1, r + 1, c - 2);
        double op8 = prob(N, K - 1, r - 1, c - 2);

        double result = op1 + op2 + op3 + op4 + op5 + op6 + op7 + op8;
        map.put(key, result);
        return result;
    }

}
