import java.util.HashSet;

class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] letterArr = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            letterArr[i] = new HashSet<String>();
        }
        for (String idea : ideas) {
            letterArr[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        long result = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                long numsOfshareFirstLetter = 0;
                for (String ideaA : letterArr[i]) {
                    if (letterArr[j].contains(ideaA)) {
                        numsOfshareFirstLetter++;
                    }
                }
                result += 2 * ((letterArr[i].size() - numsOfshareFirstLetter)
                        * (letterArr[j].size() - numsOfshareFirstLetter));
            }
        }
        return result;
    }
}
