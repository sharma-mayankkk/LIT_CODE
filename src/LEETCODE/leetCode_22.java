package LEETCODE;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class leetCode_22 {
    public static void solve(int n, StringBuilder curr, List<String> ans, int open, int close) {
        if (curr.length() == 2 * n) {
            ans.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            solve(n, curr, ans, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (open > close) {
            curr.append(')');
            solve(n, curr, ans, open, close + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0, close = 0;
        solve(n, new StringBuilder(), ans, open, close);

        return ans;
    }
}
