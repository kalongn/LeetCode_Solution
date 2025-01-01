class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num != 0) {
            if(isEven(num)) {
                num/=2;
            } else {
                num-=1;
            }
            steps++;
        }
        return steps;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
