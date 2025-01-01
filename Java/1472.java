import java.util.Stack;

class BrowserHistory {

    private Stack<String> backwardHistory;
    private Stack<String> forwardHistory;

    public BrowserHistory(String homepage) {
        backwardHistory = new Stack<>();
        forwardHistory = new Stack<>();
        backwardHistory.push(homepage);
    }

    public void visit(String url) {
        forwardHistory.clear();
        backwardHistory.push(url);
    }

    public String back(int steps) {
        while ((backwardHistory.size() > 1) && (steps > 0)) {
            forwardHistory.push(backwardHistory.pop());
            steps--;
        }
        return backwardHistory.peek();
    }

    public String forward(int steps) {
        while ((!forwardHistory.empty()) && (steps > 0)) {
            backwardHistory.push(forwardHistory.pop());
            steps--;
        }
        return backwardHistory.peek();
    }
}