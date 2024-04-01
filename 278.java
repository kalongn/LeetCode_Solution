class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isBadVersion(middle) && !isBadVersion(middle - 1)) {
                return middle;
            } else if (!isBadVersion(middle)) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}
