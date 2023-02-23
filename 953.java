class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            innerloop: for (int j = 0; j < words[i].length(); j++) {
                // if the length of first word is greater then 2nd.
                if (j >= words[i + 1].length()) {
                    return false;
                }
                // if the word character in any point is less then the next word character in
                // this alphabetorder. End the check for this specific character
                if (order.indexOf(words[i].charAt(j)) < order.indexOf(words[i + 1].charAt(j))) {
                    break innerloop;
                }
                // if the word character in any point is greater then the next word character in
                // this alphabetorder, return false;
                if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
                    return false;
                }
            }
        }
        // return true if the code succesfully loop over all elements.
        return true;
    }
}
