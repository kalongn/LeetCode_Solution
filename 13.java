class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        sum -= 2;
                    }
                    break;
                case 'X':
                    sum += 10;
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                        sum -= 2;
                    }
                    break;
                case 'L':
                    sum += 50;
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        sum -= 20;
                    }
                    break;
                case 'C':
                    sum += 100;
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                        sum -= 20;
                    }
                    break;
                case 'D':
                    sum += 500;
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        sum -= 200;
                    }
                    break;
                case 'M':
                    sum += 1000;
                    if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                        sum -= 200;
                    }
                    break;
                default:
                    break;
            }
        }
        return sum;
    }
}