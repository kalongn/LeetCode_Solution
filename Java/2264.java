class Solution {
    public String largestGoodInteger(String num) {
        int ans = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2))
                ans = Math.max(ans, num.charAt(i) - '0');
        }
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 3; i++)
            sb.append((char) (48 + ans));
        return ans != -1 ? sb.toString() : "";
    }
}
