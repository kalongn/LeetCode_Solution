class Solution {
    public int findComplement(int num) {
        int amountOfBit = 0, numDup = num;
        while (numDup > 0) {
            numDup >>= 1;
            amountOfBit++;
        }
        int mask = (1 << amountOfBit) - 1;
        return num ^ mask;
    }
}
