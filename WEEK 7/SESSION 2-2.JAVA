import java.util.*;

class BrowserHistory {

    private List<String> history;
    private int current;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        current = 0;
    }

    public void visit(String url) {
        // Remove all forward history
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }

        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() - 1, current + steps);
        return history.get(current);
    }
}
INPUT;
Input:
["BrowserHistory","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

OUTPUT;
[null,null,null,"google.com","leetcode.com","google.com",
 null,"linkedin.com","google.com","leetcode.com"]
