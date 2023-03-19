class WordDictionary {
    private WordDictionary[] links;
    private boolean isEnd;

    public WordDictionary() {
        links = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;
        for (char c : word.toCharArray()) {
            if (curr.links[c - 'a'] == null)
                curr.links[c - 'a'] = new WordDictionary();
            curr = curr.links[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (WordDictionary ch : curr.links) {
                    if (ch != null && ch.search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            if (curr.links[c - 'a'] == null) {
                return false;
            }
            curr = curr.links[c - 'a'];
        }
        return curr != null && curr.isEnd;
    }
}