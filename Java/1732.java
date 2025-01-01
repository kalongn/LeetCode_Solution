import java.util.Arrays;

class Solution {
    public int largestAltitude(int[] gain) {
        int[] distances = new int[gain.length + 1];
        distances[0] = 0;
        for (int i = 0; i < gain.length; i++) {
            distances[i + 1] = distances[i] + gain[i];
        }
        Arrays.sort(distances);
        return distances[gain.length];
    }
}

class Solution2 {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestPoint = currentAltitude;

        for (int altitudeGain : gain) {
            currentAltitude += altitudeGain;
            highestPoint = Math.max(highestPoint, currentAltitude);
        }
        return highestPoint;
    }
}
