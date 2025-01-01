class Solution {
    public int maximumSwap(int num) {
        char[] numArr = Integer.toString(num).toCharArray();
        int maxIndex = -1, swapIndexOne = -1, swapIndexTwo = -1;
        for (int i = numArr.length - 1; i >= 0; i--) {
            if (maxIndex == -1 || numArr[i] > numArr[maxIndex]) {
                maxIndex = i;
            } else if (numArr[i] < numArr[maxIndex]) {
                swapIndexOne = i;
                swapIndexTwo = maxIndex;
            }
        }
        if (swapIndexOne != -1 && swapIndexTwo != -1) {
            char temp = numArr[swapIndexOne];
            numArr[swapIndexOne] = numArr[swapIndexTwo];
            numArr[swapIndexTwo] = temp;
        }
        return Integer.parseInt(new String(numArr));
    }
}