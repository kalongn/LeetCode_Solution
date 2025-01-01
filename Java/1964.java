import java.util.List;

class Solution {
    List<Integer> answer;

    private int binarySearchRight(int[] A, int target, int right) {
        if (right == 0) {
            return 0;
        }
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length, listLength = 0;
        int[] answer = new int[n], list = new int[n];

        for (int i = 0; i < n; i++) {
            int height = obstacles[i];
            int index = binarySearchRight(list, height, listLength);
            if (index == listLength) {
                listLength++;
            }
            list[index] = height;
            answer[i] = index + 1;
        }
        return answer;
    }
}
