import java.util.Arrays;

class Solution {

    private int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] < key) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        int potlen = potions.length;
        int maxPotion = potions[potlen - 1];
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);
            if (minPotion > maxPotion) {
                result[i] = 0;
                continue;
            }
            int index = lowerBound(potions, (int) minPotion);
            result[i] = potlen - index;
        }
        return result;
    }
}
