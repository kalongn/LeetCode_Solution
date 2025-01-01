class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (searchWord.length() > sentence.length()) {
            return -1;
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= searchWord.length() &&
                    words[i].substring(0, searchWord.length()).equals(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}