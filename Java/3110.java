class Solution {
    public int scoreOfString(String s) {
        final int N = s.length() - 1;
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }
        return result;
    }
}
