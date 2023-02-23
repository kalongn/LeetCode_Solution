import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int max = 1;
        for(int i = 0; i < s.length(); i++) {
            HashSet<Character> letters = new HashSet<>();
            letters.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++) {
                if(letters.contains(s.charAt(j))) {
                    break;
                }
                letters.add(s.charAt(j));
            }
            if(max < letters.size()) {
                max = letters.size();
            }
        }
        return max;
    }
}
