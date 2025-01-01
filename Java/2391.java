class Solution {
    public int garbageCollection(String[] gar, int[] travel) {
        int p = 0, m = 0, g = 0, sum = 0;

        for (int i = 0; i < gar.length; i++) {
            for (char ch : gar[i].toCharArray()) {
                if (ch == 'P')
                    p = i;
                else if (ch == 'M')
                    m = i;
                else if (ch == 'G')
                    g = i;
                sum++; // add 1 min for every pick-up
            }
        }

        for (int i = 1; i < travel.length; i++)
            travel[i] = travel[i] + travel[i - 1];

        if (p != 0)
            sum += travel[p - 1]; // travel time till last P
        if (m != 0)
            sum += travel[m - 1]; // travel time till last M
        if (g != 0)
            sum += travel[g - 1]; // travel time till last G
        return sum;
    }
}
