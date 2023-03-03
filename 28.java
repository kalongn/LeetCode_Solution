class Solution {
    public int strStr(String haystack, String needle) {
        int lenH = haystack.length();
        int lenN = needle.length();
        if (lenH < lenN) {
            return -1;
        }
        for (int i = 0; i < lenH - lenN + 1; i++) {
            if (haystack.substring(i, i + lenN).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
