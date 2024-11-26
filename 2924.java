class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];

        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        int champ = -1;
        int champCount = 0;

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                champCount++;
                champ = i;
            }
        }

        return champCount > 1 ? -1 : champ;
    }
}