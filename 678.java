class Solution {
    public boolean checkValidString(String s) {
        int omin = 0, omax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                omax++;
                omin++;
            } else if (s.charAt(i) == ')') {
                omax--;
                omin--;
            } else {
                omax++;
                omin--;
            }
            if (omax < 0) {
                return false;
            }
            omin = Math.max(0, omin);
        }
        return omin == 0;
    }
}
