class Solution {
    public int minAddToMakeValid(String s) {
        int stackSize = 0, result = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                stackSize++;
            } else {
                if (stackSize == 0) {
                    result++;
                } else {
                    stackSize--;
                }
            }
        }
        return result + stackSize;
    }
}
