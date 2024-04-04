class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int bracketCount = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                bracketCount++;
            } else if (i == ')') {
                bracketCount--;
            }
            result = Math.max(result, bracketCount);
        }
        return result;
    }
}
