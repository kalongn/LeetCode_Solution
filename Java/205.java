class Solution {
    public boolean isIsomorphic(String s, String t) {
        int mapS[] = new int[128];
        int mapT[] = new int[128];

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
                return false;
            }
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}