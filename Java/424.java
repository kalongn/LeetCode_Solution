class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;
        for (int right = 0; right < n; right++) {
            maxCount = Math.max(maxCount, ++freq[s.charAt(right) - 'A']);
            if (right - left + 1 - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

// don't need to update maxCount in the if since it is valid at one point, a new
// window must have the same maxCount or larger for that window to have a chance
// to be larger then the current one.˝