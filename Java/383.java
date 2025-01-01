class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, letters[c - 'a']);
            if (index == -1) {
                return false;
            }
            letters[c - 'a'] = index + 1;
        }
        return true;
    }
}
