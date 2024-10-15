class Solution {
    public long minimumSteps(String s) {
        int firstNotOne = s.length() - 1;
        for (int i = firstNotOne; i >= 0; i--) {
            if (s.charAt(i) != '1') {
                firstNotOne = i;
                break;
            }
        }
        long sum = 0;
        for (int i = firstNotOne; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sum += firstNotOne - i;
                firstNotOne--;
            }
        }
        return sum;
    }
}
