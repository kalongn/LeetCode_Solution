class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int start = 0, ends1 = s1.length - 1, ends2 = s2.length - 1,
                s1WordsLength = s1.length, s2WordsLength = s2.length;

        if (s1WordsLength > s2WordsLength) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        while (start < s1WordsLength && s1[start].equals(s2[start])) {
            ++start;
        }

        while (ends1 >= 0 && s1[ends1].equals(s2[ends2])) {
            ends1--;
            ends2--;
        }

        return ends1 < start;
    }
}
