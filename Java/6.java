class Solution {
    public String convert(String s, int numRows) {

        // Get the length of the String input
        int lenOfS = s.length();

        // edge Cases
        if (lenOfS <= 1 || numRows <= 1) {
            return s;
        }

        // Create a String array
        String[] strArr = new String[numRows];

        // Change to value for every strArr[] from null to an empty String
        for (int i = 0; i < numRows; i++) {
            strArr[i] = "";
        }

        // Calculate how large the section is since the relationship is
        // 3 -> 5, 4 -> 6, 5 ->7
        int section = numRows * 2 - 2;

        // loop over the entire String
        for (int i = 0; i < lenOfS; i++) {

            // get the index the item will be added it
            int index = i % section;

            // if the index is less then numRows, that mean it is an element insert
            // vertically.
            // else if the index is equal or greater then numRwos, that mean it is an
            // element insert in a reverse diagonal line. Which then we can use the section
            // and subtract our index from it to get which strArr it will add to.
            if (index < numRows) {
                strArr[index] += s.charAt(i);
            } else {
                strArr[section - index] += s.charAt(i);
            }
        }

        // concatenate everything into a single string.
        String returnStr = "";
        for (String i : strArr) {
            returnStr += i;
        }

        // return our result.
        return returnStr;
    }
}
