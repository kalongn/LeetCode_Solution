class Solution {
    public int numberOfBeams(String[] bank) {
        int previous = 0, result = 0;
        for (String s : bank) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
            if (count > 0) {
                result += previous * count;
                previous = count;
            }
        }
        return result;
    }
}