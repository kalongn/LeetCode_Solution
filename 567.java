class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // loop over the entire String,
        // s2.length() - s1.length + 1 to remove some useless Iteration at the end of
        // the String.
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            // create an int array of 26 characters
            int[] charAppearance = new int[26];
            // add All the character from the active window from s2 into the array by
            // increaseing the value by 1 if it appeas.
            for (int j = 0; j < s1.length(); j++) {
                charAppearance[(int) s2.charAt(i + j) - 97]++;
            }
            // reduce the number by 1 if a character is present in the int array.
            for (int j = 0; j < s1.length(); j++) {
                charAppearance[(int) s1.charAt(j) - 97]--;
            }
            // if the entire array is 0 that mean all the charaxcters are the same from s2
            // active window and s1,
            if (allZeros(charAppearance)) {
                return true;
            }
        }
        return false;
    }

    // the O(26) loop
    private boolean allZeros(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}