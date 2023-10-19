import java.lang.StringBuilder;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder(), tb = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (i != '#') {
                sb.append(i);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        for (char i : t.toCharArray()) {
            if (i != '#') {
                tb.append(i);
            } else if (tb.length() > 0) {
                tb.deleteCharAt(tb.length() - 1);
            }
        }
        return sb.toString().equals(tb.toString());
    }
}
