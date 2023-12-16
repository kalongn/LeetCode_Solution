class Solution {
    public boolean isAnagram(String s, String t) {
        int sl = s.length(), tl = t.length();
        if (sl != tl) {
            return false;
        }
        int[] charCount = new int[26];
        for (int i = 0; i < sl; i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int i : charCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char i : s.toCharArray()) {
            count[i - 'a']++;
        }
        for (char i : t.toCharArray()) {
            count[i - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
