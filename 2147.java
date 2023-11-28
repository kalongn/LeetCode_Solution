class Solution {
    public int numberOfWays(String s) {
        int a = 1, b = 0, c = 0, mod = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == 'S') {
                a = (a + c) % mod;
                c = b;
                b = a;
                a = 0;
            } else {
                a = (a + c) % mod;
            }
        return c;
    }
}
