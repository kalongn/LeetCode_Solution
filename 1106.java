import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {
        char[] arr = expression.toCharArray();
        int[] index = new int[1];
        return evaluate(arr, index);
    }

    private boolean evaluate(char[] expression, int[] index) {
        char currChar = expression[index[0]];
        index[0]++;

        if (currChar == 't') {
            return true;
        }
        if (currChar == 'f') {
            return false;
        }

        index[0]++; // skip (

        if (currChar == '!') {
            boolean result = !evaluate(expression, index);
            index[0]++;
            return result;
        }

        List<Boolean> values = new ArrayList<>();
        while (expression[index[0]] != ')') {
            if (expression[index[0]] != ',') {
                values.add(evaluate(expression, index));
            } else {
                index[0]++;
            }
        }
        index[0]++;

        if (currChar == '&') {
            for (boolean i : values) {
                if (!i) {
                    return false;
                }
            }
            return true;
        }

        if (currChar == '|') {
            for (boolean i : values) {
                if (i) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }
}
