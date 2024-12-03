class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int sIndex = 0;
        for (int space : spaces) {
            while (sIndex < space) {
                sb.append(s.charAt(sIndex));
                sIndex++;
            }
            sb.append(' ');
        }
        sb.append(s.substring(sIndex));
        return sb.toString();
    }
}