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
}
