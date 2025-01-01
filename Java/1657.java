import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        int[] word1Frequency = new int[26];
        int[] word2Frequency = new int[26];

        for (int i = 0; i < word1Array.length; i++) {
            word1Frequency[word1Array[i] - 'a']++;
            word2Frequency[word2Array[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (word1Frequency[i] > 0 ^ word2Frequency[i] > 0) {
                return false;
            }
        }
        Arrays.sort(word1Frequency);
        Arrays.sort(word2Frequency);
        return Arrays.equals(word1Frequency, word2Frequency);
    }
}
