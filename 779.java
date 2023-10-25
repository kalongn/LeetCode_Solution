class Solution {
    public int kthGrammar(int n, int k) {
        return (Integer.bitCount(k - 1) & 1) == 0 ? 0 : 1;
    }
}
