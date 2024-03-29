import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] dict = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> combos = new ArrayList<>();
        backtrack(combos, digits.toCharArray(), "", dict);
        return combos;
    }

    public void backtrack(List<String> combos, char[] digits, String s, String[] dict) {
        if (s.length() == digits.length) {
            combos.add(s);
            return;
        }
        int i = s.length();
        int digit = digits[i] - '0';
        for (char letter : dict[digit].toCharArray()) {
            backtrack(combos, digits, s + Character.toString(letter), dict);
        }
    }
}