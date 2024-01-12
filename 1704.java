class Solution {
    public boolean halvesAreAlike(String s) {
        char[] word = s.toCharArray();
        int firstHalf = 0, secondHalf = 0;
        int middle = word.length / 2;
        for (int i = 0; i < middle; i++) {
            if (isVowels(word[i])) {
                firstHalf++;
            }
            if (isVowels(word[middle + i])) {
                secondHalf++;
            }
        }
        return firstHalf == secondHalf;
    }

    public boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }
}
