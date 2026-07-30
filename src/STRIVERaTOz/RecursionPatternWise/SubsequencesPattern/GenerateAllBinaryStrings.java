package STRIVERaTOz.RecursionPatternWise.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

//Generate all binary strings
//Problem Statement: Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.
//
//A binary string is a string consisting only of characters '0' and '1'.
public class GenerateAllBinaryStrings {
    public static void generate(int n, StringBuilder sb, List<String> ans) {

        if (sb.length() == n) {
            ans.add(sb.toString());
            return;
        }

        // Choose 0
        sb.append('0');
        generate(n, sb, ans);
        sb.deleteCharAt(sb.length() - 1);

        // Choose 1
        if (sb.isEmpty() || sb.charAt(sb.length() - 1) != '1') {
            sb.append('1');
            generate(n, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, new StringBuilder(), ans);
        return ans;
    }
}
