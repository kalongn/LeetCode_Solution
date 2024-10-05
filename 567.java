class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            int[] charAppearance = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                charAppearance[(int) s2.charAt(i + j) - 97]++;
            }
            for (int j = 0; j < s1.length(); j++) {
                charAppearance[(int) s1.charAt(j) - 97]--;
            }
            if (allZeros(charAppearance)) {
                return true;
            }
        }
        return false;
    }

    private boolean allZeros(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}