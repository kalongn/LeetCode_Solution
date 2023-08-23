class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (!isLetterOrDigit(arr[left])) {
                left++;
                continue;
            }
            if (!isLetterOrDigit(arr[right])) {
                right--;
                continue;
            }
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
