class Solution {
    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < word.length()) {
            int count = 0;
            char curChar = word.charAt(index);
            while (index < word.length() && count < 9 && curChar == word.charAt(index)) {
                count++;
                index++;
            }
            result.append(count).append(curChar);
        }
        return result.toString();
    }
}
