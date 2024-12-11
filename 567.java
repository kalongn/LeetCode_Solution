class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == s2Freq[i]) {
                matches++;
            }
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int left = s2.charAt(i) - 'a';
            int right = s2.charAt(i + s1.length()) - 'a';

            if (matches == 26) {
                return true;
            }

            s2Freq[right]++;
            if (s2Freq[right] == s1Freq[right]) {
                matches++;
            } else if (s2Freq[right] == s1Freq[right] + 1) {
                matches--;
            }

            s2Freq[left]--;
            if (s2Freq[left] == s1Freq[left]) {
                matches++;
            } else if (s2Freq[left] == s1Freq[left] - 1) {
                matches--;
            }
        }
        return matches == 26;
    }
}