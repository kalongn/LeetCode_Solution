interface MountainArray {
    public int get(int index) {}

    public int length() {}
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0;
        int right = n - 1;
        int mid;
        int res = -1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                res = mid;
                right = mid - 1;
            }
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                left = mid + 1;
        }

        int x = bsAscending(mountainArr, target, 0, res - 1);
        int y = bsDescending(mountainArr, target, res, n - 1);
        if (x == -1 || y == -1)
            return Math.max(x, y);
        else
            return Math.min(x, y);
    }

    public int bsAscending(
            MountainArray mountainArr, int target, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (target < mountainArr.get(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public int bsDescending(MountainArray mountainArr, int target, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (target < mountainArr.get(mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
