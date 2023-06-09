class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if ((int) letters[i] - (int) target > 0) {
                return letters[i];
            }
        }
        return letters[0];
    }
}