class Solution {
    public String decodeAtIndex(String s, int k) {
        k--;
        int n = s.length();
        long size = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                size *= (ch - '0');
            } else {
                size++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                size /= (ch - '0');
            } else {
                k %= size;
                size--;
                if (size == k) {
                    return ch + "";
                }
            }
        }
        return null;
    }
}
