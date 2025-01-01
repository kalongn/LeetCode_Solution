class Solution {
    public int numSteps(String s) {
        int result = 0;
        int currentIndex = s.length() - 1;
        int carry = 0;
        while (currentIndex >= 1) {
            if ((s.charAt(currentIndex) - '0') + carry == 1) {
                result += 2;
                carry = 1;
            } else {
                result++;
            }
            currentIndex--;
        }
        return result + carry;
    }
}
