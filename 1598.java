class Solution {
    public int minOperations(String[] logs) {
        int curr = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("../")) {
                curr = Math.max(0, curr - 1);
            } else if (!logs[i].equals("./")) {
                curr++;
            }
        }
        return curr;
    }
}
