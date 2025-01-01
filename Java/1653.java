class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        for (char i : s.toCharArray()) {
            if (i == 'a') {
                aCount++;
            }
        }
        int bCount = 0;
        int result = s.length();
        for (char i : s.toCharArray()) {
            if (i == 'a') {
                aCount--;
            }
            result = Math.min(result, aCount + bCount);
            if (i == 'b') {
                bCount++;
            }
        }
        return result;
    }
}
