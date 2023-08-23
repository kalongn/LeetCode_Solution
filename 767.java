class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26]; // to Store Frequency of each alphabet
        char[] arr = s.toCharArray();

        // store the frequency
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - 'a']++;
        }

        // find the max frequency
        int max = 0, letter = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                letter = i;
            }
        }

        // if max is more than half then not possible
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        // distribute the max freq char into even indices
        int idx = 0;
        char[] res = new char[s.length()];
        while (freq[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            freq[letter]--;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                // all even indices filled, so switch to odd indices
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                freq[i]--;
            }

        }

        return String.valueOf(res);
    }
}