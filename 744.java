class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char i : letters) {
            if (i > target) {
                return i;
            }
        }
        return letters[0];
    }
}