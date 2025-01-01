class Solution {
    public int maxScore(String s) {
        int result = 0;
        int zeros = 0, ones = 0;
        char[] arr = s.toCharArray();
        for(char i : arr) {
            if(i == '1') {
                ones++;
            }
        }

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == '0') {
                zeros++;
            } else {
                ones--;
            }
            result = Math.max(result, zeros + ones);
        }
        return result;
    }
}