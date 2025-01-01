import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int low = 0, high = tokens.length - 1, score = 0;
        Arrays.sort(tokens);
        while (low <= high) {
            if (power >= tokens[low]) {
                power -= tokens[low];
                score++;
                low++;
            } else if (low < high && score > 0) {
                power += tokens[high];
                score--;
                high--;
            } else {
                return score;
            }
        }
        return score;
    }
}
