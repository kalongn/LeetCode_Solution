import java.util.*;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int result = 0;
        for (int i = 0; i < students.length; i++) {
            result += Math.abs(students[i] - seats[i]);
        }
        return result;
    }
}