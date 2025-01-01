class Solution {
    public int minimumLength(String s) {
        char[] string = s.toCharArray();
        if (string.length < 2) {
            return string.length;
        }
        int left = 0, right = string.length - 1;
        while (left < right && string[left] == string[right]) {
            char i = string[left];
            while (left <= right && string[left] == i) {
                left++;
            }
            while (right > left && string[right] == i) {
                right--;
            }
        }
        return right - left + 1;
    }
}