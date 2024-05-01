class Solution {
    public String reversePrefix(String word, char ch) {
        char[] result = word.toCharArray();
        int left = 0;
        for (int right = 0; right < word.length(); right++) {
            if (result[right] == ch) {
                while (left <= right) {
                    swap(result, left, right);
                    left++;
                    right--;
                }
                return new String(result);
            }
        }
        return word;
    }

    private void swap(char[] characters, int index1, int index2) {
        char temp = characters[index2];
        characters[index2] = characters[index1];
        characters[index1] = temp;
    }
}
