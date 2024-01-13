class Solution {
    public int minSteps(String s, String t) {
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        int[] sF = new int[26];
        int[] tF = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sF[sA[i] - 'a']++;
            tF[tA[i] - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (tF[i] < sF[i]) {
                result += Math.abs(sF[i] - tF[i]);
            }
        }
        return result;
    }
}
