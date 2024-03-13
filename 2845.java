class Solution {
    public int pivotInteger(int n) {
        if (n == 1) {
            return n;
        }
        int leftValue = 1, rightValue = n;
        int sumLeft = leftValue, sumRight = rightValue;

        while (leftValue < rightValue) {
            if (sumLeft < sumRight) {
                leftValue++;
                sumLeft += leftValue;
            } else {
                rightValue--;
                sumRight += rightValue;
            }

            if (sumLeft == sumRight && leftValue + 1 == rightValue - 1) {
                return leftValue + 1;
            }
        }
        return -1;
    }
}
