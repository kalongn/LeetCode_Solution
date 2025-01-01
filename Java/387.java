class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < sc.length; i++) {
            if (freq[sc[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
