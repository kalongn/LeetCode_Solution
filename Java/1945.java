class Solution {
    public int getLucky(String s, int k) {
        StringBuilder temp = new StringBuilder();
        int result = 0;
        for (char i : s.toCharArray()) {
            temp.append(i - 'a' + 1);
        }
        while (k-- > 0) {
            result = 0;
            for (int i = 0; i < temp.length(); i++) {
                result += (temp.charAt(i) - '0');
            }
            temp = new StringBuilder(String.valueOf(result));
        }
        return result;
    }
}
