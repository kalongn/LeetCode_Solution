class Solution {

    private int deltaX(int[] input1, int[] input2) {
        return input1[0] - input2[0];
    }

    private int deltaY(int[] input1, int[] input2) {
        return input1[1] - input2[1];
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int firstDeltaX = deltaX(coordinates[0], coordinates[1]);
        int firstDeltaY = deltaY(coordinates[0], coordinates[1]);

        for (int i = 2; i < coordinates.length; i++) {
            if (firstDeltaX * deltaY(coordinates[0], coordinates[i]) != firstDeltaY
                    * deltaX(coordinates[0], coordinates[i])) {
                return false;
            }
        }
        return true;
    }
}