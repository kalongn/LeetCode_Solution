class Solution {
    public String firstPalindrome(String[] words) {
        for (String i : words) {
            if (new StringBuilder(i).reverse().toString().equals(i)) {
                return i;
            }
        }
        return "";
    }
}