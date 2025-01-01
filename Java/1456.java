import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int current = 0;
        for (int i = 0; i < k; i++) {
            current = vowels.contains(s.charAt(i)) ? current + 1 : current;
        }
        int max = current;
        for (int i = k; i < s.length(); i++) {
            current = vowels.contains(s.charAt(i)) ? current + 1 : current;
            current = vowels.contains(s.charAt(i - k)) ? current - 1 : current;
            max = Math.max(max, current);
        }
        return max;
    }
}