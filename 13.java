class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        char before = '0';
        for (int i = arr.length - 1; i >= 0; i--) {
            switch (arr[i]) {
                case 'I':
                    sum += before == 'V' || before == 'X' ? -1 : 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += before == 'L' || before == 'C' ? -10 : 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += before == 'D' || before == 'M' ? -100 : 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
            before = arr[i];
        }
        return sum;
    }
}