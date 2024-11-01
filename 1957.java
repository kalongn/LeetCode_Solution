class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        char rear = s.charAt(0), middle = s.charAt(1);
        result.append(rear);
        result.append(middle);
        for (int i = 2; i < s.length(); i++) {
            char current = s.charAt(i);
            if (s.charAt(i) == middle && middle == rear) {
                continue;
            }
            rear = middle;
            middle = current;
            result.append(current);
        }
        return result.toString();
    }
}
