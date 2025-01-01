class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0, strL = s.length();
        String returnStr = "";
        for (int i = 0; i < strL; i++) {
            char charAtI = s.charAt(i);
            left = i;
            right = i;

            // remove dupes for left side character
            while (left >= 0 && s.charAt(left) == charAtI) {
                left--;
                // this number lowest is -1.
            }

            // removes dupes for right side character
            while (right < strL && s.charAt(right) == charAtI) {
                right++;
            }

            // check for further palindrom after accounting for the "dupes" char
            // from the String.
            while (left >= 0 && right < strL && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            // update the returnString
            // left + 1 since the left could enter -1 which the lowest we want here
            // is 0.
            if (right - (left + 1) > returnStr.length()) {
                returnStr = s.substring(left + 1, right);
            }
        }
        return returnStr;
    }
}
