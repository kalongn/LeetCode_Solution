import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String i : path.split("/")) {
            if (i.isEmpty() || ".".equals(i))
                continue;
            if ("..".equals(i)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(i);
        }
        return "/" + String.join("/", stack);
    }
}
