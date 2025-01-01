import java.util.*;

class Solution {
    class Node {
        Map<String, Node> next = new HashMap<>();
        boolean isEnd;
    }

    Node root = new Node();

    public List<String> removeSubfolders(String[] folder) {
        for (String path : folder) {
            Node p = root;

            for (String dir : path.split("/")) {
                if (!p.next.containsKey(dir)) {
                    p.next.put(dir, new Node());
                }
                p = p.next.get(dir);
            }
            p.isEnd = true;
        }

        List<String> result = new ArrayList<String>();
        for (String path : folder) {
            Node p = root;
            boolean isValid = true;

            for (String dir : path.split("/")) {         
                if (p.isEnd) {
                    isValid = false;
                    break;
                }
                p = p.next.get(dir);
            }
            if (isValid) {
                result.add(path);
            }
        }
        return result;
    }
}