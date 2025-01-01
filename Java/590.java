import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraverse(root, result);
        return result;
    }

    private void postOrderTraverse(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node i : root.children) {
            postOrderTraverse(i, result);
        }
        result.add(root.val);
    }
}