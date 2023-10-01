class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        int firstIndex, lastIndex;
        char[] ch = s.toCharArray();
        char temp;
        for (int index = 0; index < len; index++) {
            firstIndex = index;
            while (++index < len && ch[index] != ' ')
                ;
            lastIndex = index - 1;

            while (firstIndex < lastIndex) {
                temp = ch[firstIndex];
                ch[firstIndex++] = ch[lastIndex];
                ch[lastIndex--] = temp;
            }
        }
        return new String(ch);
    }
}
