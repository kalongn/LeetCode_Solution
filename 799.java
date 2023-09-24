class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double[] cup = new double[query_row + 2];
        cup[0] = (double) poured;

        for (int i = 0; i < query_row; ++i) {
            for (int j = i; j >= 0; --j) {
                double spill = (cup[j] - 1) / 2;
                if (spill > 0) {
                    cup[j] = spill;
                    cup[j + 1] += spill;
                } else {
                    cup[j] = 0;
                    cup[j + 1] += 0;
                }
            }
        }

        if (cup[query_glass] > 1) {
            return 1;
        } else {
            return cup[query_glass];
        }
    }
}
