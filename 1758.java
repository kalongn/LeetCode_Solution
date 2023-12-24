class Solution {
    public int minOperations(String s) {
        int countZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    countZero++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    countZero++;
                }
            }
        }
        return Math.min(countZero, s.length() - countZero);
    }
}
