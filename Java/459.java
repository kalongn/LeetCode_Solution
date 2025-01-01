class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String allVariation = s + s;
        allVariation = allVariation.substring(1, allVariation.length() - 1);
        return allVariation.contains(s);
    }
}
