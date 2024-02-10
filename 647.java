class Solution {
    public int countSubstrings(String S) {
        int length = S.length(), result = 0;
        for (int i = 0; i < length; i++) {
            int left = i - 1, right = i;
            while (right < length - 1 && S.charAt(right) == S.charAt(right + 1))
                right++;
            result += (right - left) * (right - left + 1) / 2;
            i = right++;
            while (left >= 0 && right < length && S.charAt(right++) == S.charAt(left--))
                result++;
        }
        return result;
    }
}
