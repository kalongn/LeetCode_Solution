class Solution {
    public int appendCharacters(String s, String t) {
        int sameCharCount = 0;
        for (int i = 0; i < s.length() && sameCharCount < t.length(); i++) {
            if (s.charAt(i) == t.charAt(sameCharCount)) {
                sameCharCount++;
            }
        }
        return t.length() - sameCharCount;
    }
}
