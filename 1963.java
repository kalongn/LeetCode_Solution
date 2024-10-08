class Solution {
    public int minSwaps(String s) {
        int stackSize = 0;
        for (char i : s.toCharArray()) {
            if (i == '[') {
                stackSize++;
            } else if (stackSize > 0) {
                stackSize--;
            }
        }
        return (stackSize + 1) / 2;
    }
}
