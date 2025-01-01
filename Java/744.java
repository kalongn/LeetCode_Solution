class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char i : letters) {
            if (i > target) {
                return i;
            }
        }
        return letters[0];
    }
}

class Solution2 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}