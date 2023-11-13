import java.util.*;

class Solution {

    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i'
                || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I';
    }

    public String sortVowels(String s) {
        List<Integer> index = new ArrayList<>();
        List<Character> allVowels = new ArrayList<>();
        char[] charS = s.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (isVowel(charS[i])) {
                allVowels.add(charS[i]);
                index.add(i);
            }
        }
        Collections.sort(allVowels);
        for (int i = 0; i < index.size(); i++) {
            charS[index.get(i)] = allVowels.get(i);
        }
        return new String(charS);
    }
}
