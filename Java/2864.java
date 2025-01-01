class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for (char b : s.toCharArray()) {
            if (b == '1') {
                count++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count - 1; i++) {
            result.append('1');
        }
        for (int i = 0; i < s.length() - count; i++) {
            result.append('0');
        }
        result.append('1');
        return result.toString();
    }
}
