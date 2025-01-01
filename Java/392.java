class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        int index = 0;
        for (char i : t.toCharArray()) {
            if (index < sArray.length) {
                if (i == sArray[index]) {
                    index++;
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
        return index == sArray.length;
    }
}
