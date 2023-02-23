class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 0) {
            return 0;
        }
        int max = 1;
        int curr = -1, other = -1;
        outerloop: for (int i = 0; i < fruits.length; i++) {
            int count = 1;
            curr = fruits[i];
            other = -1;
            innerloop: for (int j = i + 1; j < fruits.length; j++) {
                if (fruits[j] == curr || fruits[j] == other) {
                    count++;
                }
                if (other == -1 && fruits[j] != curr) {
                    other = fruits[j];
                    count++;
                }
                if (fruits[j] != curr && fruits[j] != other) {
                    break innerloop;
                }
            }
            if (max < count) {
                max = count;
            }
            if (max > fruits.length - i) {
                break outerloop;
            }
        }
        return max;
    }
}
