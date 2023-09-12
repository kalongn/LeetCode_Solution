import java.util.Arrays;

class Solution {
    public int minDeletions(String s) {
        int[] frequency = new int[26];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        Arrays.sort(frequency);
        int highest = frequency[25], previous = highest;
        for (int i = 24; i >= 0 && frequency[i] != 0 && previous != 0; i--) {
            previous = Math.min(frequency[i], previous - 1);
            highest += previous;
        }
        return s.length() - highest;
    }
}
