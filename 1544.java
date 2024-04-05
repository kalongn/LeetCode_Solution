class Solution {
    public String makeGood(String s) {
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }
}
