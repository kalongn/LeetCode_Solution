import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int cnt = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            while (len > 0) {
                String curr = q.poll();
                for (int i = 0; i < 4; i++) {
                    char c = curr.charAt(i);
                    String up = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
                    String dwn = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);
                    if (up.equals(target) || dwn.equals(target)) {
                        return cnt + 1;
                    }
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(dwn)) {
                        q.offer(dwn);
                        visited.add(dwn);
                    }
                }
                len--;
            }
            cnt++;
        }
        return -1;
    }
}