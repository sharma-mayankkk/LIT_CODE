package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;
//Generate Parentheses

import java.util.ArrayList;
import java.util.List;

//Problem Statement: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class GenerateAllParentheses {
    public static boolean isValid(StringBuilder sb) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                count++;
            } else if (sb.charAt(i) == ')') {
                count--;
            }

            if (count < 0) return false;
        }
        return count == 0;
    }


    public static void generate(int n, StringBuilder sb, List<String> ans) {
        if (sb.length() == 2 * n) {
            if (isValid(sb)) ans.add(sb.toString());
            return;
        }

        sb.append('(');
        generate(n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        generate(n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static List<String> solve(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, new StringBuilder(), ans);
        return ans;
    }

    //optimal approach:
    public static void generate2(int n, StringBuilder sb, List<String> ans, int open, int close) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            generate2(n, sb, ans, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            generate2(n, sb, ans, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> solve2(int n) {
        List<String> ans = new ArrayList<>();
        int open = 0;
        int close = 0;
        generate2(n, new StringBuilder(), ans, open, close);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(3));
    }
}
