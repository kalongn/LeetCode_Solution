import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictionarySet = new HashSet<>(dictionary);
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 1; j <= wordArray[i].length(); j++) {
                String root = wordArray[i].substring(0, j);
                if (dictionarySet.contains(root)) {
                    wordArray[i] = root;
                }
            }
        }
        return String.join(" ", wordArray);
    }
}
