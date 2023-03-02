class Solution {
    /*public int compress(char[] chars) {
        int length = 0;
        int sameCharCount = 1;
        boolean sameChar = false;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                sameChar = true;
                sameCharCount++;
                continue;
            } else if (sameChar) {
                length++;
                length += (sameCharCount / 10 + 1);
                sameChar = false;
            } else {
                length++;
            }
        }
        return length;
    }*/
    public static int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
}