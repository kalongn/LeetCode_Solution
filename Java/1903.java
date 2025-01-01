class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        while (i >= 0) {
            if (isOdd(num.charAt(i))) {
                return num.substring(0, i + 1);
            }
            i--;
        }
        return "";
    }

    private boolean isOdd(char i) {
        if (i == '1' || i == '3' || i == '5' || i == '7' || i == '9') {
            return true;
        }
        return false;
    }
}
